package lotto.utils.enums;

public enum Code {

    Error("[ERROR]"),
    WINNING("당첨"),
    BONUS("보너스");

    private final String code;

    Code(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
