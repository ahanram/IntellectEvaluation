package IntellectRequirment.Intellect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Ahan Ram
 *
 */
@SpringBootApplication
@ComponentScan
public class SpringIntellectApplication 
{
    public static void main( String[] args )
    {
    	
    	SpringApplication.run(SpringIntellectApplication.class, args);
        System.out.println( "App started succesfullys" );
    }
}
