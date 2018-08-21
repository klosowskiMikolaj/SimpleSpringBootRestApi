package mgr.datarepo.uplink;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import mgr.datarepo.uplink.controller.UplinkController;
import mgr.datarepo.uplink.entity.Uplink;
import mgr.datarepo.uplink.service.UplinkService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore
@RunWith(SpringRunner.class)
@WebMvcTest(UplinkController.class)
public class UplinkControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UplinkService uplinkService;

    private String mapToJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String str = objectMapper.writeValueAsString(object);
        return str;
    }

    @Test

    public void createAnimal_shouldReturnRepresentationOfCreatedEntity() throws Exception {
        Uplink uplink = TestObjects.Uplink();
        uplink.setId(null);

        Uplink persisted = TestObjects.Uplink();

        Mockito.when(uplinkService.save(uplink)).thenReturn(persisted);

        mockMvc.perform(post("/uplink")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapToJson(uplink)))

                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.devEUI").value(persisted.getDevEUI()));
    }
}
