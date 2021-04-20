package com.example;

import com.example.entity.PurchaseItem;
import com.example.utils.Constants;
import com.example.utils.TaxesUtils;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;

public class SalesTaxesTest {
    private String input1 =
            "1 book at 12.49\n" +
            "1 music CD at 14.99\n" +
            "1 chocolate bar at 0.85";

    private String output1 =
            "1 book: 12.49\n" +
            "1 music CD: 16.49\n" +
            "1 chocolate bar: 0.85\n" +
            "Sales Taxes: 1.5\n" +
            "Total: 29.83\n";

    private String input2 =
            "1 imported box of chocolates at 10.00\n" +
            "1 imported bottle of perfume at 47.50";

    private String output2 =
            "1 imported box of chocolates: 10.5\n" +
            "1 imported bottle of perfume: 54.63\n" +
            "Sales Taxes: 7.63\n" +
            "Total: 65.13\n";

    private String input3 =
            "1 imported bottle of perfume at 27.99\n" +
            "1 bottle of perfume at 18.99\n" +
            "1 packet of headache pills at 9.75\n" +
            "1 box of imported chocolates at 11.25";

    private String output3 =
            "1 imported bottle of perfume: 32.19\n" +
            "1 bottle of perfume: 20.89\n" +
            "1 packet of headache pills: 9.75\n" +
            "1 box of imported chocolates: 11.81\n" +
            "Sales Taxes: 6.66\n" +
            "Total: 74.64\n";

    @Test
    public void input1Test() {
        testCase(input1, output1);
    }

    @Test
    public void input2Test() {
        testCase(input2, output2);
    }

    @Test
    public void input3Test() {
        testCase(input3, output3);
    }

    private void testCase(String input1, String output1) {
        List<PurchaseItem> purchaseItemsList = inputTolist(input1);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        TaxesUtils.calculateOutput(purchaseItemsList);

        assertEquals(output1, outputStream.toString());
    }

    private List<PurchaseItem> inputTolist(String input) {
        List<PurchaseItem> purchaseItemsList = new ArrayList<>();
        Arrays.stream(input.split("\n")).forEach(item -> {
            Matcher m = Pattern.compile(Constants.INPUT_ITEM_REGEX).matcher(item);
            if (m.matches()) {
                purchaseItemsList.add(new PurchaseItem(m.group(2), Integer.parseInt(m.group(1)),
                        new BigDecimal(String.format(Constants.DECIMAL_FORMAT, m.group(3), m.group(4)))));
            }
        });
        return purchaseItemsList;
    }
}

