package co.com.manuel.jpa.answer;

import co.com.manuel.modelXmen.answer.ModelXmenAnswer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface JPARepositoryXmenAnswer extends CrudRepository<XmenDataAnswer, Integer>, QueryByExampleExecutor<XmenDataAnswer> {

    @Query(value = "select 1 as id, sum(is_mutant) as count_mutant_dna, sum(is_human) as count_human_dna, (sum(is_mutant) / sum(is_human))as ratio from dna_read", nativeQuery = true)
    XmenDataAnswer findRatioXmen();
}
