package lotto.constants;

public enum StaticMessage {
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_PAYMENT("구입금액을 입력해 주세요."),
    PRINT_LOTTO_COUNT("개를 구매했습니다."),
    PRINT_RESULT_NOTICE("당첨 통계%n---");

    private final String message;

    StaticMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return getMessage();
    }
}
