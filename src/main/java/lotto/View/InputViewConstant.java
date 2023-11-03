package lotto.View;

public enum InputViewConstant {
    ASK_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ASK_LOTTO_RESULT("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputViewConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
