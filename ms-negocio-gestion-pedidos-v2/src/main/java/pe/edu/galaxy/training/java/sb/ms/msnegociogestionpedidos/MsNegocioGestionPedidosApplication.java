package pe.edu.galaxy.training.java.sb.ms.msnegociogestionpedidos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsNegocioGestionPedidosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsNegocioGestionPedidosApplication.class, args);
	}

}
