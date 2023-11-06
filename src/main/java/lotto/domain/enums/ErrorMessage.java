package lotto.domain.enums;

public enum ErrorMessage {

    MONEY_AMOUNT_ERROR_MESSAGE("[ERROR] 구입 금액은 1000원 단위만 가능합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
