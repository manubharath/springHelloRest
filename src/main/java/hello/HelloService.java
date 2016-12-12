package hello;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
	
	@HystrixCommand (fallbackMethod = "myFallbackMethod", commandKey = "HelloRest",	threadPoolKey = "HelloRestThreadPool")
	public UserClass helloMethod() throws Exception {
		//UserClass uc = new UserClass();
		RestTemplate restTemplate = new RestTemplate();
		UserClass uc = restTemplate.getForObject("http://10.251.117.84:9080/HelloRest", UserClass.class);
		//uc.setId("1");
		//uc.setName("Bharath");
		System.out.println("Returing UserClass object from Primary Method");
		//return uc;
		//throw new Exception();
		return uc;
	}
	
	@HystrixCommand (commandKey = "HelloRestFallback",	threadPoolKey = "HelloRestFallbackThreadPool")
	public UserClass myFallbackMethod(){
		
		//UserClass uc2 = new UserClass();
		//uc.setId("2");
		//uc.setName("SBK");
		RestTemplate restTemplate = new RestTemplate();
		UserClass uc = restTemplate.getForObject("http://10.251.117.84:9080/HelloRestFallback", UserClass.class);
		System.out.println("Returing UserClass object from Fallback");
		return uc;
		
	}

}
