package com.example;

import com.example.entity.PurchaseItem;
import com.example.utils.Constants;
import com.example.utils.TaxesUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SalesTaxes {
    public static void main( String[] args ) {
        List<PurchaseItem> purchaseItems = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println(Constants.INSTRUCTIONS);
        System.out.println(Constants.ENTER_ITEM);

        String inputString = scanner.nextLine();
        while (!inputString.trim().equalsIgnoreCase("0")) {
            if (!StringUtils.isEmpty(inputString)){
                Matcher m = Pattern.compile(Constants.INPUT_ITEM_REGEX).matcher(inputString);
                if (m.matches()) {
                    purchaseItems.add(new PurchaseItem(m.group(2), Integer.parseInt(m.group(1)),
                            new BigDecimal(String.format(Constants.DECIMAL_FORMAT, m.group(3), m.group(4)))));
                } else {
                    System.out.println(Constants.INPUT_ERROR);
                }
            }

            System.out.println(Constants.ENTER_ITEM);
            inputString = scanner.nextLine();
        }

        TaxesUtils.calculateOutput(purchaseItems);

        scanner.close();
        return;
    }
}
