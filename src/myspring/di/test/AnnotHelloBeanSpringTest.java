package myspring.di.test;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.annot.Hello;
import myspring.di.annot.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class AnnotHelloBeanSpringTest {
	@Autowired
	@Qualifier("helloA")
	Hello hello;
	
	@Resource(name="stringPrinter")
	Printer printer;
	
	@Test @Ignore
	public void hellobean() {
		assertEquals("Hello 어노테이션", hello.sayHello());
		hello.print();
		assertEquals("Hello 어노테이션", printer.toString());
	}
	
	@Test
	public void hellobean2() {
		System.out.println("--- Contructor Injection 확인 ---");
		hello.print();
	}
}
