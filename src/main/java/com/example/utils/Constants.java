package com.example.utils;

import java.math.BigDecimal;
import java.nio.file.PathMatcher;

public class Constants {
    public static final BigDecimal BASIC_TAX = new BigDecimal(0.1);
    public static final BigDecimal IMPORTED_TAX = new BigDecimal(0.05);

    public static final String[] NO_TAXES_GOODS = {"book", "chocolate", "pill"};
    public static final String[] IMPORTED_GOODS = {"imported"};

    public static final String INPUT_ITEM_REGEX = "(\\d+) (.*) at (\\d+).(\\d+)";
    public static final String DECIMAL_FORMAT = "%s.%s";
    public static final String OUTPUT_FORMAT = "%s %s: %s";

    public static final String INSTRUCTIONS = "Enter the item list in the following format: {quantity} {item name} at {price} \n Press 0 to finish\n";
    public static final String INPUT_ERROR = "ERROR: Input must be in the following format: {quantity} {item name} at {price} \n";
    public static final String ENTER_ITEM = "Please enter new item: ";

    public static final String SALES_OUTPUT = "Sales Taxes: %s";
    public static final String TOTAL_OUTPUT = "Total: %s";
}
