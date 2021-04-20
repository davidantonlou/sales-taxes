package com.example.entity;

import com.example.utils.Constants;

import java.math.BigDecimal;
import java.util.Arrays;

public class PurchaseItem {
    private String name;
    private Integer quantity;
    private BigDecimal prize;

    public PurchaseItem(String name, Integer quantity, BigDecimal prize) {
        this.name = name;
        this.quantity = quantity;
        this.prize = prize;
    }

    public BigDecimal getTax() {
        BigDecimal tax = new BigDecimal(1);

        if (Arrays.stream(Constants.IMPORTED_GOODS).anyMatch(getName()::contains))
            tax = tax.add(Constants.IMPORTED_TAX);

        if (!Arrays.stream(Constants.NO_TAXES_GOODS).anyMatch(getName()::contains))
            tax = tax.add(Constants.BASIC_TAX);

        return tax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrize() {
        return prize;
    }

    public void setPrize(BigDecimal prize) {
        this.prize = prize;
    }
}
