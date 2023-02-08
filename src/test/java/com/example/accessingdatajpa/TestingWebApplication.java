package com.example.accessingdatajpa;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class TestingWebApplication {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AddressBookRepository AddressBookRepository;
    @Test
    public void AddingBuddies() throws Exception{
        this.mockMvc.perform(post("http://localhost:8080/BuddyInfo?name=Waleed&number=9999999999&AddressBookId=1"));
        this.mockMvc.perform(get("http://localhost:8080/viewAddressBook?address-id=1")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Waleed")));
    }

    @Test
    public void removingBuddies() throws Exception{
        this.mockMvc.perform(post("http://localhost:8080/RemoveBuddy?buddyName=Waleed&AddressBookId=1"));
        String result = this.mockMvc.perform(get("http://localhost:8080/viewAddressBook?address-id=1")).andReturn().getResponse().getContentAsString();
        assert(! result.contains("Waleed"));

    }

}