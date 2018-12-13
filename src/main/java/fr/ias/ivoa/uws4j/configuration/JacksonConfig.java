package fr.ias.ivoa.uws4j.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Configuration
public class JacksonConfig {

    @Bean
    public ObjectMapper buildObjectMapper() {
       ObjectMapper objectMapper =  new ObjectMapper();
       objectMapper.setSerializationInclusion(Include.NON_NULL);
       objectMapper.registerModule(new JavaTimeModule());
       objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
       return objectMapper;
       
    }
}
