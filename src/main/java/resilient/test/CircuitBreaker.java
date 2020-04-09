package resilient.test;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class CircuitBreaker {
	
	
	@io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker(name = "backendA", fallbackMethod = "nameFallBack")
	public Mono<String> getName (String name) {
		System.out.println("Inside original method call");
		if (name != null) {
			return Mono.just("Hi " + name);
				
		}
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Mono.error(new RuntimeException("Some exception"));
		
	}
	
	
	public Mono<String> nameFallBack (String name, Exception ex) {
		System.out.println("Inside fall back");
		return Mono.just("Dummy name return");
	}
	
}
