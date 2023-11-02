package lotto.domain.constants;

public enum OutputViewMessage {
    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    OutputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
