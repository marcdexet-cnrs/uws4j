package fr.ias.ivoa.uws4j.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class JaxbConfig {

	@Bean 
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller =  new Jaxb2Marshaller();
		marshaller.setPackagesToScan("org.ivoa.uws");
		return marshaller;
	}
}
