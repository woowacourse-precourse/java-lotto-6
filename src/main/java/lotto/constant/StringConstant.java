package lotto.constant;

public enum StringConstant {

    COMMA_SPACE(", "),

    COMMA(",");

    private final String constant;

    StringConstant(String constant) {
        this.constant = constant;
    }

    public String value() {
        return this.constant;
    }

}
