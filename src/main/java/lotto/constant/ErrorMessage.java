package lotto.constant;
public enum ErrorMessage {
    ERROR_OUT_OF_RANGE_NUMBER("입력한 숫자가 정해진 범위에서 벗어난 숫자입니다."),
    ERROR_NOT_NUMBER("정수가 아닌 값이 입력되었습니다."),
    ERROR_NOT_DIVISIBLE_AMOUNT("로또 구매 금액은 로또 개별 금액 단위로만 가능합니다."),
    ERROR_NOT_MATCHED_NUMBER_COUNT("입력한 숫자의 개수가 맞지 않습니다."),
    ERROR_DUPLICATED_BONUS_NUMBER("보너스 번호는 당첨 번호와 중복될 수 없습니다."),
    ERROR_DUPLICATED_LOTTO_NUMBER("로또 번호는 중복 번호가 존재할 수 없습니다."),
    ;
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return UIConstant.ERROR_TAG + " " + message;
    }
}
