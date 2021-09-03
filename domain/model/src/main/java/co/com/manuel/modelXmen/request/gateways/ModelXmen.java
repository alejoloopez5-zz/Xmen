package co.com.manuel.modelXmen.request.gateways;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Builder(toBuilder = true)
@RequiredArgsConstructor
@AllArgsConstructor
public class ModelXmen {

    private Integer id;
    private List<String> dna;
    private Double mutant;
    private Double human;

}
