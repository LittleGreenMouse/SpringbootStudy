package cn.littlegreenmouse.hello.restful;

import cn.littlegreenmouse.hello.controller.ArticleRestController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@Slf4j
@SpringBootTest
public class ArticleRestControllerTest {
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new ArticleRestController()).build();
    }

    @Test
    public void saveArticle() throws Exception {
        String article = "{\n"+
            "    \"id\": 1,\n" +
            "    \"author\": \"LittleMouse\",\n" +
            "    \"title\": \"NB\",\n" +
            "    \"content\": \"Restful api test\",\n" +
            "    \"createTime\": \"2019-10-28 15:07:16\",\n" +
            "    \"readers\":[{\"name\":\"zh\",\"age\":21},{\"name\":\"whr\",\"age\":21}]\n" +
            "}";
        MvcResult result = mockMvc.perform(
            MockMvcRequestBuilders.request(HttpMethod.POST, "/rest/articles")
                .contentType("application/json")
                .content(article))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.author").value("LittleMouse"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.data.readers[0].age").value(21))
                .andDo(print())
                .andReturn();
        log.info(result.getResponse().getContentAsString());
    }
}
