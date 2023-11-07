package lotto.constant;

public enum ErrorMessage {
    ENTER_NOT_INTEGER_NUMBER("[ERROR] 숫자가 아닌 문자를 입력하였습니다."),
    ENTER_NOT_UNDIVIDED_NUMBER_OF_THOUSAND("[ERROR] 1000으로 나누어 떨어지지 않은 숫자를 입력하였습니다."),
    ENTER_NOT_SIX_LENGTH("[ERROR] 6자리 입력을 하지 않았습니다."),
    ENTER_DUPLICATE_NUMBER("[ERROR] 중복된 숫자를 입력하였습니다."),
    ENTER_DUPLICATE_BONUS_NUMBER("[ERROR] 중복된 보너스 숫자를 입력하였습니다."),
    ENTER_OUT_OF_LANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
