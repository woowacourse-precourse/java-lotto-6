package lotto.message;

public enum OutputMessage {
    ASK_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ASK_WINNING_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER("보너스 번호를 입력해 주세요.");
    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}
