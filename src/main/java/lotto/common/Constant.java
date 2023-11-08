package lotto.common;

public enum Constant {

    LOTTO_NUMBER_MIN(1),
    LOTTO_NUMBER_MAX(45),
    LOTTO_NUMBERS_MAX_LENGTH(6),
    COMMA(","),
    BLANK(" "),
    LINE("\n"),
    LOTTO_TICKET_PRICE(1000);

    private final Object value;

    Constant(Object value) {
        this.value = value;
    }

    public int getIntValue() {
        return (int) this.value;
    }

    public String getCharValue() {
        return (String) this.value;
    }

}
