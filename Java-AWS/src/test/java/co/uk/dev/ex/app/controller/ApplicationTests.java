package co.uk.dev.ex.app.controller;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class ApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void verifyHelloMessage() throws Exception {
        String patternString = "(Hello AWS Continuous Delivery! From host: ).*\\/\\d+.\\d+.\\d+.\\d+";
        Matcher<String> regexMatcher = Matchers.matchesRegex(patternString);

        this.mockMvc.perform(get("/hello")).andExpect(status().isOk())
                .andExpect(content().string(regexMatcher));
    }
}
