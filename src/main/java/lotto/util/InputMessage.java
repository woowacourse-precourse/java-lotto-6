package lotto.util;

public enum InputMessage {
    INPUT_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
