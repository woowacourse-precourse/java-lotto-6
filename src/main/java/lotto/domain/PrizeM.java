package lotto.domain;

public enum PrizeM {
    FIVE("(5,000원)"),FOUR("(50,000원)"), THREE("(1,500,000원)"), TWO("(30,000,000원)"), ONE("(2,000,000,000원)");
    private final String value;

    PrizeM(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
