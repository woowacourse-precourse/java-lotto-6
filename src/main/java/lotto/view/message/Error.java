package lotto.view.message;

public enum Error implements Messageable {
    PURCHASE_AMOUNT_VALIDATION_ERROR("로또 구입 금액은 1000단위의 양의 정수여야만 합니다");

    private final String CODE = "[ERROR] ";
    private String message;

    Error(String message) {
        this.message = CODE + message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
