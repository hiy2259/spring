package myspring.di.annot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("helloA")
public class Hello {
//	<property name="name", value="">
//	@Value("������̼�")
	String name;
//	<property name="stringPrinter", ref="sPrinter">
//	@Autowired
//	@Qualifier("stringPrinter")
	Printer printer;
	List<String> names;

	public Hello() {
		System.out.println("Hello ������ ȣ�� ��");
	}

	// Constructor Isnjection
	@Autowired
	public Hello(@Value("������") String name, @Qualifier("consolePrinter") Printer printer) {
		this.name = name;
		this.printer = printer;
	}

	public List<String> getNames() {
		return this.names;
	}

	public void setNames(List<String> list) {
		this.names = list;
	}

	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		this.printer.print(sayHello());
	}

}
