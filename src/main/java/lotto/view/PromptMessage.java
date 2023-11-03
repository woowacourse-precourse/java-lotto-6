package lotto.view;

public enum PromptMessage {
    INPUT_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ;

    private final String message;

    PromptMessage(String message) {
        this.message = message;
    }
}
