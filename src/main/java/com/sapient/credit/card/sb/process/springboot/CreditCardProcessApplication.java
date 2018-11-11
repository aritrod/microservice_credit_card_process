package com.sapient.credit.card.sb.process.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

/**
 * Credit card procession boot application
 *
 */
@SpringBootApplication(scanBasePackages={"com.sapient.credit.card"})
@EnableAutoConfiguration(exclude= {MultipartAutoConfiguration.class})
public class CreditCardProcessApplication 
{
	
    public static void main( String[] args )
    {
    	SpringApplication.run(CreditCardProcessApplication.class, args);
    }
}
