package be.tiemenv.projects.user;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class UserControllerTest {


    @Autowired
    private MockMvc mvc;

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Test
    void getUserThatExists() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/projects/tiemenv");
        MvcResult result = mvc.perform(request)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();
        LOG.info("Status code: {}", result.getResponse().getStatus());
    }

    @Test
    void getUserThatDoesntExist() throws Exception {
        String randomId = UUID.randomUUID().toString();
        RequestBuilder request = MockMvcRequestBuilders.get("/projects/" + randomId);
        MvcResult result = mvc.perform(request)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andReturn();
        LOG.info("Status code: {}", result.getResponse().getStatus());
    }
}