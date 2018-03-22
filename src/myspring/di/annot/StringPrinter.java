package myspring.di.annot;

import org.springframework.stereotype.Component;

// <bean id="sPrinter" class="xxx.StringPringer"> = @Component("stringPrinter")
@Component("stringPrinter")
public class StringPrinter implements Printer {
	private StringBuffer buffer = new StringBuffer();

	public void print(String message) {
		this.buffer.append(message);
	}

	public String toString() {
		return this.buffer.toString();
	}
}
