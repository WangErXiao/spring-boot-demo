package com.example;

import com.example.factory.MyFactoryBean;
import com.example.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@Autowired
	private HelloService helloService;


	@Autowired
	private MyFactoryBean factory;

	@Autowired
	private People people;

	@RequestMapping("/")
	@ResponseBody
	People home(){
		People p=new People();
		p.setAge(10);
		p.setName("souche");
		p.setMsg(helloService.hello(p.getName()));
		return p;
	}
	@RequestMapping("/get")
	@ResponseBody
	People get() throws Exception {
		return factory.getObject();
	}

	@RequestMapping("/get1")
	@ResponseBody
	People get1() throws Exception {
		return people;
	}
}
