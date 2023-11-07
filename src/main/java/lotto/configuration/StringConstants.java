package lotto.configuration;

public enum StringConstants {
    SEPERATE_STANDARD(",");

    private final String value;

    StringConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
