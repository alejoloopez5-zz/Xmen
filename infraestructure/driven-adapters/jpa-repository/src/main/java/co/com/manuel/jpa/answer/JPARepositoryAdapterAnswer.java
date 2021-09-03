package co.com.manuel.jpa.answer;

import co.com.manuel.jpa.AdapterOperations;
import co.com.manuel.modelXmen.answer.ModelXmenAnswer;
import co.com.manuel.modelXmen.answer.gateways.ModelXmenrepositoryAnswer;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JPARepositoryAdapterAnswer extends AdapterOperations<ModelXmenAnswer, XmenDataAnswer, Integer, JPARepositoryXmenAnswer> implements ModelXmenrepositoryAnswer {

    @Autowired
    public JPARepositoryAdapterAnswer(JPARepositoryXmenAnswer repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, ModelXmenAnswer.ModelXmenAnswerBuilder.class).build());
    }

    @Override
    public ModelXmenAnswer findRatio() {
        return super.toEntity(repository.findRatioXmen());
    }
}
