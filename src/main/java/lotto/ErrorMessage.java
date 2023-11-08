package lotto;

public enum ErrorMessage {
    ERROR_IS_NUMBER("[ERROR]숫자만 입력가능합니다."),
    ERROR_MINIMUM_INPUT_MONEY("[ERROR] 최소 주문금액은 1000원 입니다."),
    ERROR_NUMBER_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return this.message;
    }
}
