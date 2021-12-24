package com.bhaumik.retailstore.service;

import com.bhaumik.retailstore.bean.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author admin This RetailServiceImpl help us to get final bill amount
 */
@Service
public class RetailServiceImpl implements RetailService {

    /*
     * (non-Javadoc)
     *
     * @see com.bhaumik.retailstore.service.RetailService#generateFinalBill(com.bhaumik.retailstore.bean.BillRequest)
     */
    @Override
    public long generateFinalBill(BillRequest request) {

        // fetch records and get total amount by item type
        Map<ItemType, Long> itemBifurcation = request.getItems().stream().collect(
                Collectors.groupingBy(Item::getItemType, HashMap::new, Collectors.summingLong(Item::getAmount)));

        // get Grocery Item Type amount
        Long groceryAmount = itemBifurcation.get(ItemType.GROCERIES);

        // get total amount for all items
        Long totalAmt = itemBifurcation.values().stream().reduce(0L, Long::sum);

        long eligibleAmtForDisc = totalAmt;

        // we don't give discounts on grocery items
        if (groceryAmount != null) {
            eligibleAmtForDisc = totalAmt - groceryAmount;
        }

        // get discount as per requirements
        long finalAmtAfterDisc = getDiscount(eligibleAmtForDisc, request.getUser());

        // let's not miss the grocery items in the final amount
        if (groceryAmount != null) {
            finalAmtAfterDisc = finalAmtAfterDisc + groceryAmount;
        }

        //let's give 5 discount if amount is at least 100
        if (totalAmt >= 100) {
            finalAmtAfterDisc = finalAmtAfterDisc - 5L;
        }

        return finalAmtAfterDisc;
    }

    private long getDiscount(long eligibleAmtForDisc, User user) {
		UserType type = user.getUserType();
		switch (type) {
			case EMPLOYEE:
				return (long) (eligibleAmtForDisc - eligibleAmtForDisc * 0.30);

			case AFFILIATE_STORE:
				return (long) (eligibleAmtForDisc - eligibleAmtForDisc * 0.10);

			case CUSTOMER:
				if (user.getUserRegistrationDate().isBefore(LocalDate.now().minusYears(2))) {
					//some more discount for 2 yrs or more older customers!
					return (long) (eligibleAmtForDisc - eligibleAmtForDisc * 0.05);
				}
				return eligibleAmtForDisc;

			default:
				throw new IllegalArgumentException("The customer type " + type + " is not supported");
		}
	}
}
