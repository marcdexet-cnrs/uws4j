package fr.ias.ivoa.uws4j.configuration;

import java.io.IOException;

import javax.xml.transform.Result;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * JAXB configuration
 * @author mdexet
 *
 */
@Configuration
public class JaxbConfig {

	@Bean 
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller =  new Jaxb2Marshaller();
		marshaller.setPackagesToScan("org.ivoa.uws");
		return marshaller;
	}
	
	/**
	 * Overrides the default {@link Jaxb2RootElementHttpMessageConverter} to get namespaces
	 * and use the {@link Jaxb2Marshaller} defined above.
	 * @param marshaller
	 * @return
	 */
	@Bean
	public Jaxb2RootElementHttpMessageConverter jaxb2RootElementHttpMessageConverter(Jaxb2Marshaller marshaller) {
		return new Jaxb2RootElementHttpMessageConverter() {
			@Override
			protected void writeToResult(Object o, HttpHeaders headers, Result result) throws IOException {
				marshaller.marshal(o, result);			
			}			
		};
	}
}
