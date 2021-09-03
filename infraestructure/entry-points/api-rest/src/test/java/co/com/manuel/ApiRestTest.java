package co.com.manuel;

import co.com.manuel.modelXmen.request.gateways.ModelXmen;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = ApiRest.class)
@AutoConfigureMockMvc
@EnableWebMvc
public class ApiRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private UseCaseXmen useCaseXmen;

    @InjectMocks
    private ApiRest apiRest;

    private ModelXmen modelXmen;

    @Before
    public void setUp(){

        ArrayList<String> arrli = new ArrayList<String>();
        arrli.add(0, "ATGCGA");
        arrli.add(1, "CAGTGC");
        arrli.add(2, "TTATGT");
        arrli.add(3, "AGAAGG");
        arrli.add(4, "CCCCTA");
        arrli.add(5, "TCACTZ");

        modelXmen = ModelXmen
                .builder()
                .id(1)
                .dna(arrli)
                .human(0.0)
                .mutant(1.0)
                .build();

    }

    @Test
    public void saveDna() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(apiRest).build();
        when(useCaseXmen.validateAdn(modelXmen)).thenReturn(true);

        Gson gson = new Gson();
        String json = gson.toJson(modelXmen);

        mockMvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isOk());

    }

    @Test
    public void saveDnaHuman() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(apiRest).build();
        when(useCaseXmen.validateAdn(modelXmen)).thenReturn(false);

        Gson gson = new Gson();
        String json = gson.toJson(modelXmen);

        mockMvc.perform(post("/mutant").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isForbidden());

    }

    @Test
    public void getRatio() throws Exception{
        this.mockMvc = MockMvcBuilders.standaloneSetup(apiRest).build();

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/mutant/stats")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        Assert.assertEquals(HttpStatus.OK.value(),response.getStatus());
    }




}
