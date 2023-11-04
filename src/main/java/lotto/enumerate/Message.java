package lotto.enumerate;

public enum Message {
    PLEASE_INPUT_AMOUNT("구입금액을 입력해 주세요.\n"),
    PLEASE_INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요.\n"),
    PLEASE_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.\n");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
