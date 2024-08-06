package com.example.restservice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@SpringBootTest
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {

ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private EmployeeController employeeController;

    @Test
    public void getAllEmployees(){
        Employees listEmployees = new Employees();

        given(employeeController.getEmployees()).willReturn(listEmployees);
        try {
                mockMvc.perform(get("/employees")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()));
        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }

    }

    @Test
    public void addEmployee() throws JsonProcessingException{
        Employee employee = new Employee("4", "Negus", "patoff", "nimi.williams@yahoo.com", "Consultant");
        ResponseEntity <Object> newObject = new ResponseEntity<>(HttpStatus.OK);

        String content = objectMapper.writeValueAsString(employee);
        
        given(employeeController.addEmployee(employee)).willReturn(newObject);
        try {
                mockMvc.perform(post("/employees")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON)
                .content(content))
                .andExpect(status().isOk());
        } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }

    }

}
