package com.kitri.hello1;

public class HelloMain {

	public static void main(String[] args) {
//		HelloServiceKor helloServiceKor = new HelloServiceKor();
//		String msg = helloServiceKor.helloKor("안효인");
		
		HelloServiceEng helloServiceEng = new HelloServiceEng();
		String msg = helloServiceEng.helloEng("안효인");
		
		System.out.println(msg);
	}
	
}
