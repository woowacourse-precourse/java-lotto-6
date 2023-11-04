package lotto.util;

public enum InputMessage {
    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_LOTTO_WIN_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_LOTTO_BONUS_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
