package lotto;

public enum ErrorMessage {
    INPUT_NOT_NUMBER("[ERROR] 숫자로 변환할 수 없는 입력입니다. 다시 입력해주세요."),
    NOT_DIVISIBLE_LOTTO_PRICE(String.format("[ERROR] %d으로 나누어 떨어지는 금액을 입력해야 합니다. 다시 입력해주세요.", LottoManagement.PRICE_LOTTO));

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
