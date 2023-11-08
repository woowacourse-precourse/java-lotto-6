package lotto.common.util;

public enum ErrorMessage {

    ERROR("[ERROR]"),
    SIZE(ERROR.message + " 로또 번호는 6개 입니다."),
    LIMIT(ERROR.message + " 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE(ERROR.message + " 로또 번호는 중복될 수 없습니다."),
    DUPLICATE_BONUS(ERROR.message + " 로또 번호와 보너스 번호는 중복될 수 없습니다."),
    BLANK(ERROR.message + " 값을 입력해 주세요."),
    PRICE_CHECK(ERROR.message + " 구입금액은 1,000원 단위로만 가능합니다."),
    ONLY_NUMBER(ERROR.message + " 숫자만 입력 가능합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
