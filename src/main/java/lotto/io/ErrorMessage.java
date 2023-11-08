package lotto.io;


public enum ErrorMessage {

    PRICE_OUT_OF_RANGE(ErrorConstants.PREFIX + "로또 구매 가능 금액은 1000₩ 이상이며 한번에 구매 가능한 금액은 100000₩ 이하입니다."),
    PRICE_CANNOT_DIVIDE(ErrorConstants.PREFIX + "1000₩으로 나누어 떨어지지 않아 로또를 구매할 수 없습니다."),
    VALUE_NOT_INTEGER(ErrorConstants.PREFIX + "입력한 수는 정수가 아닙니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    private static class ErrorConstants {
        private static final String PREFIX = "[ERROR] ";
    }
}

