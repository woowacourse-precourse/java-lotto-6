package lotto.view;

public enum InputViewMessage {
    INPUT_CASH_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNER_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
