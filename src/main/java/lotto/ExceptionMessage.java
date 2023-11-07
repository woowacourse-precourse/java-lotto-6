package lotto;

public enum ExceptionMessage {
    ERROR_LOTTO_DUPICATED("로또 당첨 번호에 중복된 번호가 있습니다. 다른 번호를 입력하세요."),
    ERROR_LOTTO_COUNT("로또 당첨 번호는 정확히 6개 입력해야 합니다."),
    ERROR_LOTTO_RANGE("로또 당첨 번호는 1에서 45 사이여야 합니다. 다른 번호를 입력하세요."),
    ERROR_LOTTO_INVALID_NUMBER("입력된 값은 1000으로 나누어 떨어지지 않습니다."),
    ERROR_LOTTO_INVALID_INPUT_TYPE_NUMBER("올바른 정수 형식이 아닌 입력입니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + this.message;
    }
}
