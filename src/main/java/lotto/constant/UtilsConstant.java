package lotto.constant;

public enum UtilsConstant {

    SINGLE_BLANK(" "),
    DELIMITER(",");

    private final String string;

    UtilsConstant(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }
}
