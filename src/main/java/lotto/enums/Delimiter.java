package lotto.enums;

public enum Delimiter {
    COMMA(",", "쉼표");

    private final String value;
    private final String korName;

    Delimiter(String value, String korName) {
        this.value = value;
        this.korName = korName;
    }

    public String getValue() {
        return value;
    }

    public String getKorName() {
        return korName;
    }
}
