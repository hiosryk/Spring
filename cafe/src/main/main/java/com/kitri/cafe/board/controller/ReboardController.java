package com.kitri.cafe.board.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kitri.cafe.board.model.ReboardDto;
import com.kitri.cafe.board.service.ReboardService;
import com.kitri.cafe.common.service.CommonService;
import com.kitri.cafe.member.model.MemberDto;

@Controller
@RequestMapping("/reboard")
public class ReboardController {

	@Autowired
	private CommonService commonService;
	
	@Autowired
	private ReboardService reboardService;
	
	@RequestMapping(value = "/write", method = RequestMethod.GET)
	public void write(@RequestParam Map<String, String> parameter, Model model) {
		model.addAttribute("parameter", parameter);
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(ReboardDto reboardDto, 
				@RequestParam Map<String, String> parameter, 
				Model model, HttpSession session) {
		String path = "";
		
		MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");
		if(memberDto != null) {
			int seq = commonService.getNextSeq();
			reboardDto.setSeq(seq);
			reboardDto.setId(memberDto.getId());
			reboardDto.setName(memberDto.getName());
			reboardDto.setEmail(memberDto.getEmail());
			reboardDto.setRef(seq);
			
			seq = reboardService.writeArticle(reboardDto);
			
			if(seq != 0) {
				model.addAttribute("seq", seq);
				path = "reboard/writeok";
			} else {
				path = "reboard/writefail";
			}
		} else {
			path = "";
		}
		model.addAttribute("parameter", parameter);
		return path;
	}
	
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public void view(@RequestParam("seq") int seq, 
			@RequestParam Map<String, String> parameter, Model model) {
		
		ReboardDto reboardDto = reboardService.viewArticle(seq);
		
		model.addAttribute("article", reboardDto);
		model.addAttribute("parameter", parameter);
	}
	
}








