package lotto.Enum;

public enum ErrorStatus {
    PARSE_INT_ERROR("[ERROR] 양의 정수를 입력해야 합니다."),
    NEGATIVE_INPUT_ERROR("[ERROR] 양의 정수를 입력해야 합니다."),
    NOT_DIVISION_THOUSAND_ERROR("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다."),
    WINNING_NUM_DUB_AND_SIZE_ERROR("[ERROR] 로또 번호는 중복되지 않는 6자리 숫자여야 합니다."),
    LOTTO_BOUNDARY_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    BONUS_NUM_DUB_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.")
    ;

    private final String message;

    ErrorStatus(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
