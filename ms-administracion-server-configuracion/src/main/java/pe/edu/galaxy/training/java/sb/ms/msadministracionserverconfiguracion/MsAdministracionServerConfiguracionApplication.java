package pe.edu.galaxy.training.java.sb.ms.msadministracionserverconfiguracion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class MsAdministracionServerConfiguracionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAdministracionServerConfiguracionApplication.class, args);
	}

}
