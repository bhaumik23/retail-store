package com.bhaumik.retailstore.service;

import com.bhaumik.retailstore.bean.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class RetailServiceTests {

    @InjectMocks
    private RetailServiceImpl retailService;

    @Test
    public void testOtherItemsForEmployee() {
        List<Item> listItems = new ArrayList<>();
        Item item1 = createItem("First Item", ItemType.OTHERS, 100L);
        Item item2 = createItem("Second Item", ItemType.OTHERS, 200L);

        User user = new User(1, "Bhaumik", UserType.EMPLOYEE, LocalDate.now());

        listItems.add(item1);
        listItems.add(item2);

        BillRequest billRequest = new BillRequest();
        billRequest.setUser(user);
        billRequest.setItems(listItems);

        long totalBill = retailService.generateFinalBill(billRequest);
        assertEquals(205, totalBill, 0);

    }

    @Test
    public void testOtherItemsForEmployeeWhenTotalAmountLessThan100() {
        List<Item> listItems = new ArrayList<>();
        Item item1 = createItem("First Item", ItemType.OTHERS, 10L);
        Item item2 = createItem("Second Item", ItemType.OTHERS, 20L);

        User user = new User(1, "Bhaumik", UserType.EMPLOYEE, LocalDate.now());

        listItems.add(item1);
        listItems.add(item2);

        BillRequest billRequest = new BillRequest();
        billRequest.setUser(user);
        billRequest.setItems(listItems);

        long totalBill = retailService.generateFinalBill(billRequest);
        assertEquals(21, totalBill, 0);

    }

    @Test
    public void testOtherItemsForEmployeeWhenTotalAmountIs100() {
        List<Item> listItems = new ArrayList<>();
        Item item1 = createItem("First Item", ItemType.OTHERS, 50L);
        Item item2 = createItem("Second Item", ItemType.OTHERS, 50L);

        User user = new User(1, "Bhaumik", UserType.AFFILIATE_STORE, LocalDate.now());

        listItems.add(item1);
        listItems.add(item2);

        BillRequest billRequest = new BillRequest();
        billRequest.setUser(user);
        billRequest.setItems(listItems);

        long totalBill = retailService.generateFinalBill(billRequest);
        assertEquals(85, totalBill, 0);

    }

    @Test
    public void testOtherItemsForAffiliateStore() {
        List<Item> listItems = new ArrayList<>();
        Item item1 = createItem("First Item", ItemType.OTHERS, 100L);
        Item item2 = createItem("Second Item", ItemType.OTHERS, 200L);

        User user = new User(1, "Bhaumik", UserType.AFFILIATE_STORE, LocalDate.now());

        listItems.add(item1);
        listItems.add(item2);

        BillRequest billRequest = new BillRequest();
        billRequest.setUser(user);
        billRequest.setItems(listItems);

        long totalBill = retailService.generateFinalBill(billRequest);
        assertEquals(265, totalBill, 0);

    }

    @Test
    public void testOtherItemsForCustomer() {
        List<Item> listItems = new ArrayList<>();
        Item item1 = createItem("First Item", ItemType.OTHERS, 100L);
        Item item2 = createItem("Second Item", ItemType.OTHERS, 200L);

        User user = new User(1, "Bhaumik", UserType.CUSTOMER, LocalDate.now());

        listItems.add(item1);
        listItems.add(item2);

        BillRequest billRequest = new BillRequest();
        billRequest.setUser(user);
        billRequest.setItems(listItems);

        long totalBill = retailService.generateFinalBill(billRequest);
        assertEquals(295, totalBill, 0);

    }

    @Test
    public void testGroceryItemsForEmployee() {
        List<Item> listItems = new ArrayList<>();
        Item item1 = createItem("First Item", ItemType.GROCERIES, 100L);
        Item item2 = createItem("Second Item", ItemType.GROCERIES, 200L);

        User user = new User(1, "Bhaumik", UserType.EMPLOYEE, LocalDate.now());

        listItems.add(item1);
        listItems.add(item2);

        BillRequest billRequest = new BillRequest();
        billRequest.setUser(user);
        billRequest.setItems(listItems);

        long totalBill = retailService.generateFinalBill(billRequest);
        assertEquals(295, totalBill, 0);

    }

    @Test
    public void testGroceryItemsForAffiliateStore() {
        List<Item> listItems = new ArrayList<>();
        Item item1 = createItem("First Item", ItemType.GROCERIES, 100L);
        Item item2 = createItem("Second Item", ItemType.GROCERIES, 200L);

        User user = new User(1, "Bhaumik", UserType.AFFILIATE_STORE, LocalDate.now());

        listItems.add(item1);
        listItems.add(item2);

        BillRequest billRequest = new BillRequest();
        billRequest.setUser(user);
        billRequest.setItems(listItems);

        long totalBill = retailService.generateFinalBill(billRequest);
        assertEquals(295, totalBill, 0);

    }

    @Test
    public void testGroceryItemsForCustomer() {
        List<Item> listItems = new ArrayList<>();
        Item item1 = createItem("First Item", ItemType.GROCERIES, 200L);
        Item item2 = createItem("Second Item", ItemType.GROCERIES, 200L);

        User user = new User(1, "Bhaumik", UserType.CUSTOMER, LocalDate.now());

        listItems.add(item1);
        listItems.add(item2);

        BillRequest billRequest = new BillRequest();
        billRequest.setUser(user);
        billRequest.setItems(listItems);

        long totalBill = retailService.generateFinalBill(billRequest);
        assertEquals(395, totalBill, 0);

    }

    @Test
    public void testMultipleItemsForEmployee() {
        List<Item> listItems = new ArrayList<>();
        Item item1 = createItem("First Item", ItemType.GROCERIES, 400L);
        Item item2 = createItem("Second Item", ItemType.OTHERS, 200L);

        User user = new User(1, "Bhaumik", UserType.EMPLOYEE, LocalDate.now());

        listItems.add(item1);
        listItems.add(item2);

        BillRequest billRequest = new BillRequest();
        billRequest.setUser(user);
        billRequest.setItems(listItems);

        long totalBill = retailService.generateFinalBill(billRequest);
        assertEquals(535, totalBill, 0);

    }

    @Test
    public void testMultipleItemsForAffiliateStore() {
        List<Item> listItems = new ArrayList<>();
        Item item1 = createItem("First Item", ItemType.GROCERIES, 100L);
        Item item2 = createItem("Second Item", ItemType.OTHERS, 200L);

        User user = new User(1, "Bhaumik", UserType.AFFILIATE_STORE, LocalDate.now());

        listItems.add(item1);
        listItems.add(item2);

        BillRequest billRequest = new BillRequest();
        billRequest.setUser(user);
        billRequest.setItems(listItems);

        long totalBill = retailService.generateFinalBill(billRequest);
        assertEquals(275, totalBill, 0);

    }

    @Test
    public void testMultipleItemsForCustomer() {
        List<Item> listItems = new ArrayList<>();
        Item item1 = createItem("First Item", ItemType.GROCERIES, 100L);
        Item item2 = createItem("Second Item", ItemType.OTHERS, 200L);

        User user = new User(1, "Bhaumik", UserType.CUSTOMER, LocalDate.now());

        listItems.add(item1);
        listItems.add(item2);

        BillRequest billRequest = new BillRequest();
        billRequest.setUser(user);
        billRequest.setItems(listItems);

        long totalBill = retailService.generateFinalBill(billRequest);
        assertEquals(295, totalBill, 0);
    }

    @Test
    public void testMultipleItemsForCustomerMoreThanTwoYears() {
        List<Item> listItems = new ArrayList<>();
        Item item1 = createItem("First Item", ItemType.GROCERIES, 100L);
        Item item2 = createItem("Second Item", ItemType.OTHERS, 200L);

        User user = new User(1, "Bhaumik", UserType.CUSTOMER, LocalDate.now().minusYears(3));

        listItems.add(item1);
        listItems.add(item2);

        BillRequest billRequest = new BillRequest();
        billRequest.setUser(user);
        billRequest.setItems(listItems);

        long totalBill = retailService.generateFinalBill(billRequest);
        assertEquals(285, totalBill, 0);

    }

    private Item createItem(String itemName, ItemType itemType, long amt) {
        Item item = new Item();
        item.setAmount(amt);
        item.setItemName(itemName);
        item.setItemType(itemType);
        return item;
    }
}
