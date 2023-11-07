package lotto.view;

public enum InputMessage {

    INPUT_PURCHASE_PRICE_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요.");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
