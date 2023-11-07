package lotto.exceptions;

public enum ErrorMessages {

    INVALID_PURCHASE_AMOUNT("[ERROR]구입 금액은 숫자로만 이루어져야 합니다."),
    MIN_PURCHASE_AMOUNT("[ERROR]구입 금액은 1,000원 단위이어야 합니다."),
    NON_DIVISIBLE_PURCHASE_AMOUNT("[ERROR]입력 단위가 1,000원으로 나누어 떨어지지 않습니다."),
    INPUT_ERROR("[ERROR]잘못된 값을 입력하여 다시 진행합니다."),
    DUPLICATE_ERROR("[ERROR]로또 번호에 중복된 숫자가 있습니다."),
    LENGTH_ERROR("[ERROR]로또 번호의 개수가 6개가 아닙니다."),
    ;
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
