package constants;

public enum OutputMessage {
    MONEY_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    ANSWER_LOTTO_INPUT_MESSAGE("당첨 번호를 입력해주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해주세요."),
    LOTTO_RESULT_MESSAGE("당첨 통계");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
