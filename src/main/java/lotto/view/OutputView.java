package lotto.view;

public enum OutputView {
    PURCHASE_PRICE_REQUEST("구입금액을 입력해 주세요.");

    OutputView(String message) {
        this.message = message;
    }

    private String message;

    public String getMessage() {
        return message;
    }
}
