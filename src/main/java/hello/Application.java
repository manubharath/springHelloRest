package hello;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCircuitBreaker
@ComponentScan({"hello","com.tqm.diag"})
public class Application {
    
    public static void main(String[] args) {
    	SpringApplication.run(Application.class, args);
    	
        //ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
       // System.out.println("Let's inspect the beans provided by Spring Boot:");
        
        //String[] beanNames = ctx.getBeanDefinitionNames();
       // Arrays.sort(beanNames);
        //for (String beanName : beanNames) {
           // System.out.println(beanName);
        //}
    }

}
