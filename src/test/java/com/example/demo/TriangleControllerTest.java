package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TriangleControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void doServiceTest() throws Exception {
        this.mockMvc.perform(get("/?side1=5&side2=4&side=3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"Triangle Perimeter\":12.0,\"Triangle Square\":6.0}"));
    }
}
