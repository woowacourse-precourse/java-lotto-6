package lotto.util;

public enum SpecialSign {

    SEPARATOR(","),
    BLANK(" "),
    PERCENTAGE_MESSAGE("%"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    NEW_LINE("\n");

    private String sign;

    SpecialSign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
