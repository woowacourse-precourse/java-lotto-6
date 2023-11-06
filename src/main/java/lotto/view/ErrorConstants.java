package lotto.view;

public enum ErrorConstants {
    INDIVISIBLE_BUY_AMOUNT_ERROR_MESSAGE("[ERROR] 구입 금액은 %d의 배수여야 합니다."),
    MINIMUM_BUY_AMOUNT_ERROR_MESSAGE("[ERROR] 구입할 로또 개수는 최소 %d개 이상이어야 합니다.");

    private final String message;

    ErrorConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
