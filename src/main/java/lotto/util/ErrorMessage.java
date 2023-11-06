package lotto.util;

public enum ErrorMessage {
    OUT_OF_SIZE("로또 숫자의 개수가 6개가 아닙니다."),
    DUPLICATE_NUMBER("로또 숫자가 중복됩니다."),
    NOT_IN_RANGE("로또 숫자가 1-45 사이의 숫자가 아닙니다."),
    NOT_SORT("로또 숫자가 정렬되어 있지 않습니다."),
    INPUT_NOT_NUMBER("[ERROR] 숫자만 입력해주세요."),
    INPUT_INVALID_NUMBER("[ERROR] 숫자의 크기가 너무 큽니다."),
    INPUT_NOT_THOUSAND_UNIT("[ERROR] 구입 금액을 1000원 단위로 입력해주세요."),
    INPUT_NOT_IN_RANGE("[ERROR] 당첨 번호가 1-45 사이의 숫자가 아닙니다."),
    INPUT_OUT_OF_SIZE("[ERROR] 당첨 번호의 개수가 6개가 아닙니다."),
    INPUT_DUPLICATE_NUMBER("[ERROR] 당첨 번호가 중복됩니다."),
    INPUT_BONUS_DUPLICATE("[ERROR] 보너스 번호가 당첨 번호가 중복됩니다."),
    ;

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
