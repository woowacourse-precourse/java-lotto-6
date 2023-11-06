package lotto.constants;

public enum Exceptions {

    MESSAGE_PREFIX("[ERROR] "),
    NONE_INPUT("값을 입력하세요."),
    NONE_DIGIT("입력값은 정수여야 합니다."),
    NON_MULTIPLE_OF_1000("로또 구입 금액은 1000원으로 나누어 떨어져야 합니다."),
    INVALID_LOTTO_NUMBERS_LENGTH("입력값은 6개의 정수여야 합니다."),
    OUT_OF_RANGE("입력값은 1에서 45 사이의 정수여야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("입력값은 중복되지 않는 6개의 숫자여야 합니다."),
    DUPLICATE_LOTTO_BONUS("보너스 숫자는 선택한 로또 번호와 중복될 수 없습니다.");

    private final String message;

    Exceptions(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
