package lotto.enums;

public enum InputMessages {
    INPUT_AMOUNT_MESSAGE("구입금액을 입력해주세요."),
    INPUT_WINNING_LOTTO_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");
    private final String message;

    InputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
