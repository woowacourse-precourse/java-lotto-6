package lotto.ui;

public enum OutputForm {
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요.\n"),
    ASK_WINNER_NUMBERS("당첨 번호를 입력해 주세요.\n"),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요.\n");

    private final String text;

    private OutputForm(String text) {
        this.text = text;
    }

    public void printText() {
        System.out.print(this.getText());
    }

    public String getText() {
        return text;
    }
}