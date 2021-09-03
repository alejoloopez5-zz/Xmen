package co.com.manuel.jpa.request;

import co.com.manuel.jpa.AdapterOperations;
import co.com.manuel.modelXmen.request.gateways.ModelXmen;
import co.com.manuel.modelXmen.request.gateways.ModelXmenRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JPARepositoryAdapter extends AdapterOperations<ModelXmen, XmenData, Integer, JPARepositoryXmen > implements ModelXmenRepository
/**        implements <INTERFACE DOMAIN> **/
{

    @Autowired
    public JPARepositoryAdapter(JPARepositoryXmen repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.mapBuilder(d, ModelXmen.ModelXmenBuilder.class).build());
    }

    @Override
    public ModelXmen saveXmen(ModelXmen modelXmen) {
        return super.save(modelXmen);
    }

}