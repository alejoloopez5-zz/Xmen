package co.com.manuel.modelXmen.answer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class ModelXmenAnswer {

    private Integer id;
    private Double count_mutant_dna;
    private Double count_human_dna;
    private Double ratio;
}
