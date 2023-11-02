package lotto.contents;

public enum ContentStrings {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    ContentStrings(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}