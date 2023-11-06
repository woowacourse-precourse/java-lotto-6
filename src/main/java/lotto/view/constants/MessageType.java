package lotto.view.constants;

public enum MessageType {
    COST_REQUEST_MESSAGE("구입금액을 입력해 주세요."),
    LOTTO_COUNT_MESSAGE("%s개를 구매했습니다."),
    WINNING_NUMBERS_REQUEST_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBERS_REQUEST_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
