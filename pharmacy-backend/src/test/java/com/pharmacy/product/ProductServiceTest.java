package com.pharmacy.product;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



//This is a UNIT TEST: no calls to the database, just checking if the call to the endpoint
//gives correct results. So in this case we assume that the database part works and just want to test te controller
@SpringBootTest
@AutoConfigureMockMvc
public class ProductServiceTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductRepository productRepository;

    @Test
    public void sampleTest() throws Exception {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
        this.mockMvc.perform(get("/products")).andDo(print()).andExpect(status().isOk());
        verify(productRepository).findAll();
    }
}
