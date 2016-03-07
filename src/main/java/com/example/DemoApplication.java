package com.example;

import com.example.annotation.MyAnno;
import com.example.factory.MyFactoryBean;
import com.example.service.HelloService;
import com.example.service.MyService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@SpringBootApplication
@Controller
@EnableAutoConfiguration
public class DemoApplication implements ApplicationContextAware{

	public static ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		Map<String ,Object> rel= applicationContext.getBeansWithAnnotation(MyAnno.class);

		for (String key:rel.keySet()){

			System.out.println("key:"+key);
			System.out.println("obj:"+rel.get(key).getClass().getName());

			MyService myService=(MyService)rel.get(key);
			myService.sayHello();
		}

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

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

}
