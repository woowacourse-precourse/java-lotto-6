package lotto.constant;

public enum InputConstant {
    BUYING_COST_MESSAGE("구입금액을 입력해 주세요."),

    WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요.");

    private final String message;

    InputConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
