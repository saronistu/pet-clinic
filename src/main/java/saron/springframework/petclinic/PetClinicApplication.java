package saron.springframework.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import saron.springframework.petclinic.controller.MyController;

@SpringBootApplication
public class PetClinicApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(PetClinicApplication.class, args);
        MyController myController = (MyController) ctx.getBean("myController");
        String s = myController.sayHello();
        System.out.println(s);
    }

}
