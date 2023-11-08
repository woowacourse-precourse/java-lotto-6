package lotto.message;

public enum Inquire {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요.\n"),
    WINNER_NUMBERS("당첨 번호를 입력해 주세요.\n"),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.\n");

    private final String message;

    Inquire(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.print(this.getMessage());
    }

    public String getMessage() {
        return message;
    }
}