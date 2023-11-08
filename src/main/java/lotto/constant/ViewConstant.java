package lotto.constant;

public enum ViewConstant {
    BLANK(" "),
    SEPERATOR(","),
    DASH("-");

    private final String value;

    ViewConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
