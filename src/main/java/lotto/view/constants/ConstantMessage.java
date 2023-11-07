package lotto.view.constants;

public enum ConstantMessage {
    REQUEST_INPUT_PRICE("구입금액을 입력해 주세요."),
    REQUEST_INPUT_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    ALARM_HOW_MANY_BUY_LOTTO("개를 구매했습니다."),
    ALARM_THE_RESULT_STARTING_MESSAGE("당첨 통계\n---");


    private final String message;

    ConstantMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
