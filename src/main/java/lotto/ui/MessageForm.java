package lotto.ui;

public enum MessageForm {
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요.\n");

    private final String text;

    private MessageForm(String text) {
        this.text = text;
    }

    public void printText() {
        System.out.print(this.getText());
    }

    public String getText() {
        return text;
    }
}