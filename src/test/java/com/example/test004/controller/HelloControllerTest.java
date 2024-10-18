package com.example.test004.controller;

import com.slack.api.Slack;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.request.files.FilesUploadV2Request;
import com.slack.api.methods.response.files.FilesUploadV2Response;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTest() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("hello"));
    }

    @Test
    public void getDtoTest() throws Exception {
        String name = "hello";
        int amount = 12345;

        mockMvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));
    }

    @org.junit.jupiter.api.Test
    void salesNotiFileAttachmentTest() throws SlackApiException, IOException {
        String token = "xoxb-514279666163-4095946751312-qsUcxNjh9UaDPN0gB5uFFtyM";

        System.out.println(System.getProperty("user.dir"));

        Slack.getInstance().methods(token).filesUpload(r -> r
                .file(new File("./test.txt"))
                .filename("test.txt")
                .title("Test Title")
                .channels(Arrays.asList("noti_test"))
                .initialComment("Test Initial Comment"));

    }
}