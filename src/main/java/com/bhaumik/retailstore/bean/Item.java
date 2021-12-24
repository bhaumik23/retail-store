package com.bhaumik.retailstore.bean;

/**
 * @author admin
 * This class defines for item detail.
 */
public class Item {
    private String itemName;
    private ItemType itemType;
    private long amount;

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @SuppressWarnings("unused")
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public long getAmount() {
        return amount;
    }
}
