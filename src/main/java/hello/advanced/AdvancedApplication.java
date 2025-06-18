
package hello.advanced;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdvancedApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(AdvancedApplication.class, args);
        } catch (Exception e){
            System.out.println(e);
        }

        System.out.println("Hello World");

    }

}
