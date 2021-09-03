package co.com.manuel.config;

import co.com.manuel.UseCaseXmen;

import co.com.manuel.modelXmen.answer.gateways.ModelXmenrepositoryAnswer;
import co.com.manuel.modelXmen.request.gateways.ModelXmenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public UseCaseXmen ceateUseCaseXmen(ModelXmenRepository modelXmenRepository, ModelXmenrepositoryAnswer modelXmenrepositoryAnswer) {
        return new UseCaseXmen(modelXmenRepository, modelXmenrepositoryAnswer);
    }


}
