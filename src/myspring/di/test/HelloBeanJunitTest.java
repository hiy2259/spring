package myspring.di.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;

public class HelloBeanJunitTest {

	ApplicationContext context;
	String resourceLocations = "config/beans.xml";

	@Before
	public void init() {
		// Spring Container ����
		context = new GenericXmlApplicationContext(resourceLocations);
	}

	@Test
	public void hellobean() {
		Hello hello1 = (Hello)context.getBean("hello");
		Hello hello2 = context.getBean("hello", Hello.class);
		
		// �ּҰ� ���� -> spring���� bean���� �̱������� �����ϰ� �ִ�.
		System.out.println(hello1 == hello2);
		Assert.assertSame(hello1, hello2);
	}
}
