package lotto.constant;

public enum LottoSymbol {
    LOTTO_SEPARATOR(",");

    private final String value;

    LottoSymbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
