package lotto.io.read;

public enum InputMessage {

    READ_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    READ_LOTTO_WIN_NUMBERS("\n당첨 번호를 입력해 주세요."),
    READ_LOTTO_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
