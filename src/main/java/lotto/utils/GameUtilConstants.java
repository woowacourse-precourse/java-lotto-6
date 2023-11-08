package lotto.utils;

public enum GameUtilConstants {
    LEST_DELIMITER(",");

    private final String value;

    GameUtilConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
