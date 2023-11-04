package lotto.common;

public enum InputOutputMessages {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputOutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
