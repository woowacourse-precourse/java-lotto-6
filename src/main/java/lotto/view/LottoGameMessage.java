package lotto.view;

public enum LottoGameMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요.");

    private final String message;

    LottoGameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
