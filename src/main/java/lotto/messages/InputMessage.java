package lotto.messages;

public enum InputMessage {

    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

    private final String inputView;

    InputMessage(String inputView) {
        this.inputView = inputView;
    }

    public String getInputView() {
        return inputView;
    }
}
