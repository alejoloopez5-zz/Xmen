package co.com.manuel;

import co.com.manuel.modelXmen.answer.ModelXmenAnswer;
import co.com.manuel.modelXmen.request.gateways.ModelXmen;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Api(value = "Servicio que se encarga de leer los registros dna y da informacion promedio de humanos y mutantes")
@RestController
@RequestMapping("/mutant")
@RequiredArgsConstructor
@CrossOrigin
public class ApiRest {

    private final UseCaseXmen useCaseXmen;

    @ApiOperation(value = "Metodo que obtiene el promedio de los mutantes con respecto a humanos y muestra la cantidad de cada uno")
    @GetMapping("/stats")
    public ModelXmenAnswer mutantRatio(){
        return useCaseXmen.ratio();
    }

    @ApiOperation(value = "Metodo que lee el registro para ser analizado e indicar si el dna es de persona o mutante")
    @PostMapping
    public ResponseEntity<ModelXmen> mutantPost(@RequestBody ModelXmen modelXmen) {

        HttpStatus state;

        if(useCaseXmen.validateAdn(modelXmen)) {
            state = HttpStatus.OK;
        } else {
            state = HttpStatus.FORBIDDEN;
        }

        return new ResponseEntity<ModelXmen>(state);
    }
}
