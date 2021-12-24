package com.bhaumik.retailstore;

import com.bhaumik.retailstore.bean.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RetailStoreApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    public void calculateBill() throws Exception {

        List<Item> listItems = new ArrayList<>();
        Item item1 = createItem("First Item", ItemType.OTHERS, 100L);
        Item item2 = createItem("Second Item", ItemType.OTHERS, 200L);

        User user = new User(1, "Bhaumik", UserType.EMPLOYEE, LocalDate.now());

        listItems.add(item1);
        listItems.add(item2);

        BillRequest billRequest = new BillRequest();
        billRequest.setUser(user);
        billRequest.setItems(listItems);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/retail/generateFinalBill")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(billRequest));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(content().string("205"))
        ;
    }

    private Item createItem(String itemName, ItemType itemType, long amt) {
        Item item = new Item();
        item.setAmount(amt);
        item.setItemName(itemName);
        item.setItemType(itemType);
        return item;
    }
}
