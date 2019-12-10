package ch.ffhs.pa5.latetrain.latetrainserver.infrastructure.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;

public class JacksonConfiguration {
    @Bean public Module module(){
        return new JavaTimeModule();
    }
}
