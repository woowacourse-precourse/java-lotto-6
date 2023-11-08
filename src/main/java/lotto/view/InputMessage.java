package lotto.view;

public enum InputMessage {
    REQUEST_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
