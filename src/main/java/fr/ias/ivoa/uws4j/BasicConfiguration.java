package fr.ias.ivoa.uws4j;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import fr.ias.ivoa.uws4j.configuration.JacksonConfig;
import fr.ias.ivoa.uws4j.configuration.JaxbConfig;

@Configuration
@Import({JacksonConfig.class, JaxbConfig.class})
public class BasicConfiguration {

	
}
