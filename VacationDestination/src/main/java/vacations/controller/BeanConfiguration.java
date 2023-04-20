package vacations.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import vacations.beans.Activity;
import vacations.beans.Destination;

@Configuration
public class BeanConfiguration {
    
	 @Bean
	    Destination destination() {
	        return new Destination("Hawaii", "USA", "A beautiful island paradise with sandy beaches and clear blue waters.");
	    }
	    
	    @Bean
	    Activity activity() {
	        return new Activity("Snorkeling", "Hawaii", "Explore the beautiful underwater world of Hawaii with snorkeling tours.", 50.0);
	    }
	}

