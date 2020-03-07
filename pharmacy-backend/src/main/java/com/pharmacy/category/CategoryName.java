package com.pharmacy.category;

public enum CategoryName {
    OINTMENT("Ointment"),
    AEROSOL("Aerosol"),
    INTRAVENOUS("Intravenous"),
    EYEDROPS("Eyedrops"),
    SPRAY("Spray"),
    ORAL("Oral medicine");

    private String displayName;

    CategoryName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
