package lotto.utils;

public enum Message {
    PRINT_USER_INPUT_BUY_PRICE("구입금액을 입력해 주세요."),
    PRINT_USER_BUY_LOTTO_COUNT("개를 구매했습니다."),
    PRINT_USER_ENTER_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    PRINT_USER_ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_WINNING_STATISTICS("당첨 통계"),
    PRINT_DASH("---");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
