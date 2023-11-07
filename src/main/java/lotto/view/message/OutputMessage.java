package lotto.view.message;

public enum OutputMessage {
    ASK_TO_INSERT_USER_MONEY("구입금액을 입력해 주세요."),
    ASK_TO_INSERT_LOTTO_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_TO_INSERT_LOTTO_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_NUMBER_OF_LOTTOS("개를 구매했습니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}