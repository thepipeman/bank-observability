package io.pipecrafts.digital;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DigitalApplication {

  public static void main(String[] args) {
    SpringApplication.run(DigitalApplication.class, args);
  }

}
