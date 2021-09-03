package co.com.manuel.jpa.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;


@Builder(toBuilder = true)
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dna_read")
public class XmenData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "dna")
    private String dna;

    @Column(name = "is_mutant")
    private Double mutant;

    @Column(name = "is_human")
    private Double human;
}
