package lotto.util;

public enum ErrorMessage {
    NOT_SORT("[ERROR] 로또 숫자가 정렬되어 있지 않습니다."),
    NOT_NUMBER("[ERROR] 숫자만 입력해야 합니다."),
    INVALID_NUMBER("[ERROR] 숫자의 크기가 더 작아야 합니다."),
    NOT_THOUSAND_UNIT("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
    NOT_IN_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    OUT_OF_SIZE("[ERROR] 로또 번호의 개수는 6개여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복되지 않아야 합니다."),
    BONUS_DUPLICATE("[ERROR] 보너스 번호가 로또 번호와 중복되지 않아야 합니다."),
    ;

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
