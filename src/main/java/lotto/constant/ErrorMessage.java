package lotto.constant;

public enum ErrorMessage {

    ERROR("[ERROR] "),
    ONLY_THOUSAND("1000원 단위로 입력하셔야 합니다."),
    INVALID_INPUT("1000원 이상의 값을 입력하셔야 합니다."),
    ONLY_INPUT_NUMBER("숫자만 입력하셔야 합니다."),
    ONLY_SIX_NUMBER("6개의 숫자를 입력하셔야 합니다."),
    INVALID_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_DUPLICATE("중복된 값은 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
