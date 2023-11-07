package lotto.constants;

public enum PromptMessages {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    PromptMessages(String message) {
        this.message = message;
    }

    public String getPromptMessage() {
        return message;
    }
}
