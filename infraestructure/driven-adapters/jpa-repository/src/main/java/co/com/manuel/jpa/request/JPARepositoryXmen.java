package co.com.manuel.jpa.request;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepositoryXmen extends CrudRepository<XmenData, Integer>, QueryByExampleExecutor<XmenData> {

}