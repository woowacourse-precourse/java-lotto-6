package lotto.constant;
public enum ErrorMessage {
    ERROR_OUT_OF_RANGE_NUMBER("입력한 숫자가 정해진 범위에서 벗어난 숫자입니다."),
    ERROR_NOT_NUMBER("숫자가 아닌 값이 입력되었습니다."),
    ERROR_NOT_DIVISIBLE_NUMBER("로또 구매 금액은 로또 개별 금액 단위로만 가능합니다.")
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return UIConstant.ERROR_TAG + " " + message;
    }
}
