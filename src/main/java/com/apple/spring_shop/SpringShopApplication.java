package com.apple.spring_shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringShopApplication.class, args);
		var test = new Test();
		System.out.println(test.name);
		test.hello();
	}

}

class Test {
	String name = "kim";
	void hello(){ System.out.println("안녕");  }
}

class Friend {
	String name = "kim";
	int age = 20;
	Friend(){
		this.name = "어쩌구";
	}
}