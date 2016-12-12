package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController

public class HelloController {
	@Autowired
	HelloService helloService;
	
   // @RequestMapping("/greeting")
    
  /*  public String index() {
    	
        return helloService.helloMethod();
    }*/
	//@RequestMapping("/greeting")
	
	//@RequestMapping(value = "/greeting", method = RequestMethod.GET,
			//headers = "Content-type=application/json", produces = "application/json")
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = "application/json")
	
    public UserClass greeting() {
		
		System.out.println("Request Recieved for /greeting");
    	
    	//return helloService.helloMethod();
		
		UserClass uc = new UserClass();
		
		try {
			uc=helloService.helloMethod();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Came back from HelloService - helloMethod");
		
		return uc;
		
    }
    
}
