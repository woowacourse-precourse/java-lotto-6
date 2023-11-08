package lotto.view.message;

public enum ExceptionMessage {

    ERROR_MESSAGE("[ERROR] 올바른 값을 입력해주세요"),
    ERROR_MESSAGE_ABOUT_NOT_DIVIDED_THOUSAND("[ERROR] 구입 금액은 1,000원 단위로 입력해주세요."),
    ERROR_MESSAGE_ABOUT_ZERO("[ERROR] 구입 금액은 0보다 커야 합니다."),
    ERROR_MESSAGE_ABOUT_DUPLICATED_LOTTO_NUMBERS("[ERROR] 중복되지 않는 숫자를 입력해주세요."),
    ERROR_MESSAGE_ABOUT_WRONG_RANGED_LOTTO_NUMBERS("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_MESSAGE_ABOUT_BLANK_INPUT("[ERROR] 입력값이 없습니다.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
