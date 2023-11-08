package lotto.view;

public enum InputRequestMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNIG_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

    private String requestMessage;

    InputRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    protected void println() {
        System.out.println(requestMessage);
    }
}
