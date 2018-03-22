package myspring.di.test;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	ApplicationContext context;
	
	@Autowired
	Hello hello;
	
	@Autowired
	@Qualifier("sPrinter")
	Printer printer;
	
	@Autowired
	Hello hello2;
	
	@Resource(name="cPrinter")
	Printer printer2;
	
	@Test
	public void hellobean2() {
		hello2.print();
	}
	
	@Test
	public void hellobean() {
		System.out.println(context.getClass().getName());
		System.out.println(hello.sayHello());
		Assert.assertEquals("Hello 황인용", hello.sayHello());
		hello.print();
		Assert.assertEquals("Hello 황인용", printer.toString());
	}
}
