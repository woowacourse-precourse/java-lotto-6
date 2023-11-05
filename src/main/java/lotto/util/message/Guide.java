package lotto.util.message;

public enum Guide {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요.");
    
    private final String message;

    Guide(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
