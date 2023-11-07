package lotto.exception;

public enum ExceptionMessage {
    NO_COMMA(" 로또 번호는 (,)를 기준으로 구분되어야 한다.\n"),
    DUPLICATE_NUMBER(" 로또 번호는 중복되지 않는 6개의 숫자여야 합니다.\n"),
    OUT_OF_RANGE(" 로또 번호의 숫자 범위는 1 ~ 45까지이다.\n"),
    NOT_INTEGER_VALUE(" 번호와 금액은 정수여야 합니다.\n"),
    EXCEEDED_LOTTO_SIZE(" 로또는 6개의 숫자여야 합니다.\n"),
    NOT_THOUSAND_UNIT(" 구입 금액은 1000 단위여야 한다.\n"),
    DUPLICATE_BONUSE_NUMBER(" 보너스 번호는 당첨번호와 중복되지 않아야 한다.\n");
    private final String message;
    private static final String PREFIX = "[ERROR]";

    ExceptionMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage(){
        return message;
    }

}
