package com.tw.apistackbase.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tw.apistackbase.entity.Company;
import com.tw.apistackbase.entity.Employee;
import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private com.fasterxml.jackson.databind.ObjectMapper ObjectMapper;

    @Test
    public void should_get_company_list_when_get_url_companies() throws Exception {
//        Employee employee = new Employee();
//        List<>
//        Company company = new Company();
//        this.mockMvc.perform(get("/companies"))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(
//                        MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is("001"))
//                );
    }
}
