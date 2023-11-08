package lotto.exception;

public enum ErrorMessage {

    INPUT_EMPTY("[ERROR] 입력값은 비어있지 않아야 합니다."),
    INPUT_NOT_DIGIT("[ERROR] 입력값은 정수이어야 합니다."),
    PURCHASE_UNIT_INVALID("[ERROR] 구입 금액은 1,000원 단위이어야 합니다."),
    BONUS_NUMBER_RANGE_INVALID("[ERROR] 각각의 당첨 번호는 1~45 범위의 정수이어야 합니다."),
    LOTTO_NUMBER_INPUT_NOT_RIGHT_FORMAT("[ERROR] 올바른 입력 형식이 아닙니다."),
    LOTTO_NUMBER_INPUT_LENGTH_INVALID("[ERROR] 당첨 번호의 총 길이는 6이어야 합니다."),
    LOTTO_NUMBER_DUPLICATED("[ERROR] 각 로또 번호는 중복되지 않아야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
