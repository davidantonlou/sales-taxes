package com.example.utils;

import com.example.entity.PurchaseItem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TaxesUtils {
    public static double toRoundedDouble(BigDecimal bigDecimal) {
        return bigDecimal.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public static void calculateOutput(List<PurchaseItem> purchaseItems) {
        AtomicReference<BigDecimal> total = new AtomicReference<>(BigDecimal.valueOf(0));
        AtomicReference<BigDecimal> taxes = new AtomicReference<>(BigDecimal.valueOf(0));

        AtomicReference<BigDecimal> itemTax = new AtomicReference<>(BigDecimal.valueOf(1));
        AtomicReference<BigDecimal> itemQuantity = new AtomicReference<>(BigDecimal.valueOf(0));
        purchaseItems.stream().forEach(item -> {
            itemTax.set(item.getTax());
            itemQuantity.set(new BigDecimal(item.getQuantity()));

            taxes.set(taxes.get().add(itemQuantity.get().multiply(item.getPrize().multiply(itemTax.get().subtract(new BigDecimal(1))))));
            total.set(total.get().add(itemQuantity.get().multiply(item.getPrize().multiply(itemTax.get()))));

            System.out.println(String.format(Constants.OUTPUT_FORMAT, item.getQuantity(), item.getName(),
                    TaxesUtils.toRoundedDouble(item.getPrize().multiply(itemTax.get()))));
        });
        System.out.println(String.format(Constants.SALES_OUTPUT, TaxesUtils.toRoundedDouble(taxes.get())));
        System.out.println(String.format(Constants.TOTAL_OUTPUT, TaxesUtils.toRoundedDouble(total.get())));
    }
}
