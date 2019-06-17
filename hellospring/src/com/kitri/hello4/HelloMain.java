package com.kitri.hello4;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class HelloMain {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(HelloServiceFactory.class);
		HelloService helloService = context.getBean("hs", HelloService.class);
		String msg = helloService.hello("안효인");
		
		System.out.println(msg);
		
		
		HelloService helloService1 = context.getBean("hs", HelloService.class);
		HelloService helloService2 = context.getBean("hs", HelloService.class);
		System.out.println(helloService1 + "     " + helloService2);
	}
	
}





