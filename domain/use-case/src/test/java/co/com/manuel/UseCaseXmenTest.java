package co.com.manuel;

import co.com.manuel.modelXmen.answer.ModelXmenAnswer;
import co.com.manuel.modelXmen.answer.gateways.ModelXmenrepositoryAnswer;
import co.com.manuel.modelXmen.request.gateways.ModelXmen;
import co.com.manuel.modelXmen.request.gateways.ModelXmenRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.Silent.class)
@SpringBootTest(classes = UseCaseXmen.class)
public class UseCaseXmenTest {


    @Mock
    private ModelXmenRepository modelXmenRepository;

    @Mock
    private ModelXmenrepositoryAnswer modelXmenrepositoryAnswer;

    @InjectMocks
    private UseCaseXmen useCaseXmen;

    private ModelXmenAnswer modelXmenAnswer;
    private ModelXmen modelXmenHuman;
    private ModelXmen modelXmenMutant;

    @Before
    public void setUp(){

        modelXmenAnswer = ModelXmenAnswer
                .builder()
                .id(1)
                .count_mutant_dna(15.0)
                .count_human_dna(45.0)
                .ratio(0.3333)
                .build();

        ArrayList<String> arrli = new ArrayList<String>();
        arrli.add(0, "XTGCGA");
        arrli.add(1, "CAGTGC");
        arrli.add(2, "TTATGT");
        arrli.add(3, "AGAAGG");
        arrli.add(4, "CCCCTA");
        arrli.add(5, "TCACTZ");

        modelXmenHuman = ModelXmen
                .builder()
                .id(1)
                .dna(arrli)
                .human(1.0)
                .mutant(0.0)
                .build();


        ArrayList<String> arrli2 = new ArrayList<String>();
        arrli2.add(0, "ATGCGA");
        arrli2.add(1, "CAGTGC");
        arrli2.add(2, "TTATGT");
        arrli2.add(3, "AGAAGG");
        arrli2.add(4, "CCCCTA");
        arrli2.add(5, "TCACTZ");

        modelXmenMutant = ModelXmen
                .builder()
                .id(1)
                .dna(arrli2)
                .human(1.0)
                .mutant(0.0)
                .build();
    }

    @Test
    public void validateDnaMutant(){

        Boolean response = useCaseXmen.validateAdn(modelXmenMutant);

        Assert.assertTrue(response);
    }

    @Test
    public void validateDnaHuman(){

        Boolean response = useCaseXmen.validateAdn(modelXmenHuman);

        Assert.assertFalse(response);
    }

    @Test
    public void getRatio(){
        Mockito.when(modelXmenrepositoryAnswer.findRatio()).thenReturn(modelXmenAnswer);

        ModelXmenAnswer  response = useCaseXmen.ratio();

        Assert.assertNotNull(response);
    }
}
