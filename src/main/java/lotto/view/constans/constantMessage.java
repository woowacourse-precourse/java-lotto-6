package lotto.view.constans;

public enum constantMessage {

    // Request
    ASK_PURCHASEAMOUNT("구입금액을 입력해 주세요.");

    // Response


    private final String message;

    constantMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}