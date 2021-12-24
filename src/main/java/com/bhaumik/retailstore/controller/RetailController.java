package com.bhaumik.retailstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhaumik.retailstore.bean.BillRequest;
import com.bhaumik.retailstore.service.RetailService;

/**
 * @author admin
 *
 */
@RestController
@RequestMapping("/api/retail")
@SuppressWarnings("unused")
public class RetailController {

	@Autowired
	private RetailService retailService;

	@PostMapping
	@RequestMapping("/generateFinalBill")
	public long generateFinalBill(@RequestBody BillRequest billRequest) {
		return retailService.generateFinalBill(billRequest);
	}

}
