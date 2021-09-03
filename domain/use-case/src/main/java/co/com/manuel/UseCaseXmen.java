package co.com.manuel;

import co.com.manuel.modelXmen.answer.gateways.ModelXmenrepositoryAnswer;
import co.com.manuel.modelXmen.request.gateways.ModelXmen;
import co.com.manuel.modelXmen.answer.ModelXmenAnswer;
import co.com.manuel.modelXmen.request.gateways.ModelXmenRepository;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class UseCaseXmen {

    private final ModelXmenRepository modelXmenRepository;
    private final ModelXmenrepositoryAnswer modelXmenrepositoryAnswer;

    ModelXmen modelXmen = new ModelXmen();

    private Boolean isMutant;
    private int i, j, cont;
    private String dna [][];

    public boolean validateAdn(ModelXmen model) {

        isMutant = false;
        dna = readRequest(model);
        modelXmen.setDna(model.getDna());
        for (i = 0; i < dna.length; i++) {
            for (j = 0; j < dna[0].length-3; j++) {

                if (dna[i][j].equals(dna[i][j+1]) && dna[i][j].equals(dna[i][j+2]) && dna[i][j].equals(dna[i][j+3]))
                {
                    cont = cont + 1;
                    break;
                }
            }
        }

        for (i = 0; i < dna[0].length-3; i++) {
            for (j = 0; j < dna.length; j++) {

                if (dna[i][j].equals(dna[i+1][j]) && dna[i][j].equals(dna[i+2][j]) && dna[i][j].equals(dna[i+3][j]))
                {
                    cont = cont + 1;
                    break;
                }
            }
        }

        for (i = 0; i < dna[0].length-3; i++) {
            for (j = 0; j < dna[0].length-3; j++) {

                if (dna[i][j].equals(dna[i+1][j+1]) && dna[i][j].equals(dna[i+2][j+2]) && dna[i][j].equals(dna[i+3][j+3]))
                {
                    cont = cont + 1;
                    break;
                }
            }
        }

        if (cont >= 3) {
            isMutant = true;
        }

        modelXmen.setMutant(isMutant.equals(true)? 1.0 : 0);
        modelXmen.setHuman(isMutant.equals(false)? 1.0 : 0);

        cont = 0;
        saveAdn(modelXmen);
        return isMutant;
    }

    public void saveAdn(ModelXmen modelXmen){
        modelXmenRepository.saveXmen(modelXmen);
    }

    public String[][] readRequest(ModelXmen model){

        String [][] matrix = new String [model.getDna().size()][model.getDna().get(0).length()];


        for (i = 0; i < model.getDna().size(); i++) {
            for (j = 0; j < model.getDna().get(0).length(); j++) {
                String cadena =  model.getDna().get(i);
                char[] cadena_div  = cadena.toCharArray();
                matrix[i][j] = String.valueOf(cadena_div[j]);
        }}
        i = 0;
        j = 0;
        return matrix;
        
    }

    public ModelXmenAnswer ratio(){
        return modelXmenrepositoryAnswer.findRatio();
    }

}
