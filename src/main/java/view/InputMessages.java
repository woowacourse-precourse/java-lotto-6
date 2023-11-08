package view;

public enum InputMessages {
    PURCHASE_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_NUMBER_MESSAGE("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요.");

    private String message;

    private InputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
