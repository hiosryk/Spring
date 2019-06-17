package com.kitri.hello3;

public class HelloServiceKor implements HelloService {

	private HelloDao helloDao;
	
	public HelloServiceKor(HelloDao helloDao) {
		this.helloDao = helloDao;
	}
	
//	public void setHelloDao(HelloDao helloDao) {
//		this.helloDao = helloDao;
//	}

//	public HelloServiceKor() {
//		System.out.println("HelloServiceKor 생성자 호출!!!!!");
//	}
	
	public String hello(String name) {
		return name + "님 안녕하세요!!\n" + helloDao.getGreeting();
	}
	
}
















