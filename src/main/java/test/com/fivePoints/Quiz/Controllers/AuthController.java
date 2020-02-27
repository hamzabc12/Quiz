package test.com.fivePoints.Quiz.Controllers;

import javax.security.sasl.AuthenticationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import test.com.fivePoints.Quiz.entities.ConfirmationToken;
import test.com.fivePoints.Quiz.entities.User;
import test.com.fivePoints.Quiz.repositories.ConfirmationTokenRepository;
import test.com.fivePoints.Quiz.services.IServiceUser;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	 private AuthenticationManager authenticationManager;

	
	 private IServiceUser userService;
	 
	 @Autowired
	 private ConfirmationTokenRepository confirmationTokenRepository; 
	 
	 @Autowired
	 
	    
	   

	    @PostMapping(value = "/login")
	    public ResponseEntity<?> register(@RequestBody User loginUser) throws AuthenticationException {
	    	

	        final Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(
	                        loginUser.getEmail(),
	                        loginUser.getPassword()
	                )
	        );
			return null;
	        
	        
	    }
	    
	    @PostMapping(value="/register")
	    public ResponseEntity<?> saveUser(@Valid @RequestBody User user){
	    	
	    
	    	userService.register(user);
	    	
	    	ConfirmationToken token= confirmationTokenRepository.findByUser(user);
	    	if(token !=null) {
	    		return new ResponseEntity<String>(" This email already exist \n "
	    				+ "Please check your mail to confirm your account", HttpStatus.EXPECTATION_FAILED);
	    	}
	    	
	    	ConfirmationToken confirmationToken=new ConfirmationToken(user, "confirmation-account");
	    	confirmationTokenRepository.save(confirmationToken);
	    	
	    	
	        return  new ResponseEntity<String>("Congratulations! Your account has been created"
	        		+ "Please check your email to continue the registration ", HttpStatus.ACCEPTED);
	    }

	public AuthController() {
		
	}

}
