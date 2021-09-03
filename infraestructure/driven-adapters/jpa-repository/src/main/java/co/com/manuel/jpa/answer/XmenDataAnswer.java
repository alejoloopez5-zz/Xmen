package co.com.manuel.jpa.answer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder(toBuilder = true)
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class XmenDataAnswer {

    @Id
    private Integer id;
    private Double count_mutant_dna;
    private Double count_human_dna;
    private Double ratio;
}
