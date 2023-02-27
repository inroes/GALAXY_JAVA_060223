package pe.edu.galaxy.training.java.sb.ms.msadministracionserverregistro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MsAdministracionServerRegistroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdministracionServerRegistroApplication.class, args);
	}

}
