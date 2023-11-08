package value;

public enum ErrorMessage {
    PAY_MONEY("[ERROR]구입 금액을 입력하세요."),
    PAY_PROPER_MONEY_AMOUNT("[ERROR]1000원 단위로 입력해주세요."),
    PAY_MONEY_IN_NUMBER("[ERROR]잘못된 값을 입력하였습니다."),

    LOTTO_NUMBER_OUT_OF_RANGE("[ERROR]입력한 값이 범위를 초과했습니다."),
    LOTTO_INSERT_IN_NUMBER("[ERROR]잘못된 값을 입력하였습니다."),
    LOTTO_INSERT_SIX_NUMBERS("[ERROR]6개의 수를 입력해주세요."),
    LOTTO_NUMBER_REUSED("[ERROR]중복된 값을 입력하였습니다."),

    BONUS_NUMBER_NOT_NUM("[ERROR]잘못된 값을 입력하였습니다."),
    BONUS_NUMBER_OUT_OF_RANGE("[ERROR]입력한 값이 범위를 초과했습니다."),
    BONUS_NUMBER_REUSED("[ERROR]중복된 값을 입력하였습니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getString() {
        return message;
    }
}
