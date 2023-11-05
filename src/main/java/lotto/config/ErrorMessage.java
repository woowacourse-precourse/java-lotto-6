package lotto.config;

public enum ErrorMessage {
    WRONG_LOTTO_SIZE("로또 번호는 6개의 숫자여야 합니다."),
    DUPLICATED_LOTTO("로또 번호는 서로 겹치지 않아야 합니다."),
    WRONG_LOTTO_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    WRONG_PRICE_RANGE("구입금액은 최소 1000원 이상이어야 합니다."),
    WRONG_PRICE_DIVISION("구입금액은 1000원 단위여야 합니다."),
    WRONG_BONUS_RANGE("보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_BONUS("보너스 번호는 로또 번호와 겹치지 않아야 합니다."),
    NOT_NUMERIC_STRING("정수형태의 문자열을 입력해야 합니다."),
    OUT_INTEGER_RANGE("Integer 범위내의 정수를 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String message() {
        return "[ERROR] " + message;
    }
}
