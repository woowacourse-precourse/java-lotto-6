package lotto.exception;

/**
 * 입력시 예외값 정의 enum
 */
public enum InputExceptionMessage {
    INVALID_PRICE_TYPE("[ERROR] 로또 구입 금액은 자연수여야 합니다."),
    INVALID_PRICE("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다."),
    INVALID_LOTTO_NUMBERS("[ERROR] 로또 번호는 ,(콤마)로 구분된 6개 숫자(1~45)여야 합니다."),
    DUPLICATED_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨번호와 중복되지 않아야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 1~45여야 합니다."),
    INVALID_LOTTO_DUPLICATED("[ERROR] 로또 번호는 중복되지 않은 숫자로 이루어져야 합니다."),
    ;

    private final String message;

    InputExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
