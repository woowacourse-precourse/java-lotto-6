package lotto.enumeration;

public enum ExceptionType {
    INVALID_INPUT_TYPE("[ERROR] 입력값은 숫자여야 합니다."),
    EXCEED_AMOUNT_LIMIT("[ERROR] 구입금액은 최소 1,000원, 최대 2,000,000,000원입니다."),
    AMOUNT_NOT_MULTIPLE_1000("[ERROR] 구입금액은 1,000원 단위여야 합니다."),
    INVALID_LOTTO_FORMAT("[ERROR] 당첨 번호는 쉼표(,)를 기준으로 구분된 6개의 숫자여야 합니다."),
    DUPLICATE_LOTTO_NUMS("[ERROR] 당첨 번호는 중복되지 않는 6개의 숫자여야 합니다."),
    EXCEED_LOTTO_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    EXCEED_BONUS_RANGE("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_BONUS_LOTTO("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 숫자여야 합니다.");

    private String message;
    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
