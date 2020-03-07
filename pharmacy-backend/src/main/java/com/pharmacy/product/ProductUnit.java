package com.pharmacy.product;

public enum ProductUnit {
    PILLS("pills"),

    GRAMS("ug"),
    MILLIGRAMS("mg"),
    MICROGRAMS("ug"),

    LITRES("l"),
    MILLILITERS("ml");


    private String displayUnit;
    ProductUnit(String displayUnit) {
        this.displayUnit = displayUnit;
    }

    public String getDisplayUnit() {
        return displayUnit;
    }
}
