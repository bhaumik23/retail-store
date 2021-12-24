package com.bhaumik.retailstore.service;

import com.bhaumik.retailstore.bean.BillRequest;

/**
 * @author admin
 */
public interface RetailService {

    /**
     * This method help us to get final bill amount
     *
     * @param request the bill request
     * @return the payable amount for the user
     */
    long generateFinalBill(BillRequest request);
}
