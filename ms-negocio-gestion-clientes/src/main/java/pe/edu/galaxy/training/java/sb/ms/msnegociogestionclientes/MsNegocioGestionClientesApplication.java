package pe.edu.galaxy.training.java.sb.ms.msnegociogestionclientes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsNegocioGestionClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNegocioGestionClientesApplication.class, args);
	}

}
