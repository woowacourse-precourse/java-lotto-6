package lotto.constants;

public enum InputMessages {

    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ASK_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}