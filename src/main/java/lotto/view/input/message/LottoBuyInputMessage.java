package lotto.view.input.message;

public enum LottoBuyInputMessage {
    PURCHASE_AMOUNT_PROMPT_MESSAGE("구입할 Lotto 금액을 입력해 주세요."),
    WINNING_NUMBERS_PROMPT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT_MESSAGE("보너스 번호를 입력해 주세요.");

    private final String massage;

    LottoBuyInputMessage(String massage) {
        this.massage = massage;
    }

    public String getMassage() {
        return massage;
    }
}
