package lotto.exception;

public enum ErrorMessage {
    PURCHASE_AMOUNT_NOT_NUMERIC("[ERROR] 1000 단위의 숫자를 입력해주세요."),
    PURCHASE_AMOUNT_NEGATIVE("[ERROR] 1000 단위의 양수를 입력해주세요."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE("[ERROR] 1000 으로 나누어 떨어지는 수를 입력해주세요");

    private String message;

    ErrorMessage(String s) {
    }

    public String getMessage() {
        return message;
    }
}
