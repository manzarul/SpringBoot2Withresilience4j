package resilient.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CircuitBreakerTest {
	

	
	
	public static void main(String[] args) {
		
        ConfigurableApplicationContext context = SpringApplication.run(CircuitBreakerTest.class, args);
        CircuitBreaker breaker = context.getBean(CircuitBreaker.class);

		
		for (int i = 0 ; i<200; i++) {
			try {
			if(i%1==0) {
				System.out.println(breaker.getName(null).block());
			}else {
				System.out.println(breaker.getName("Haque ").block());
			}
		}
		 catch (Exception e) {
			e.printStackTrace();
		}
		}
	}
	
	
	


}
