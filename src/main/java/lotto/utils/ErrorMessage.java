package lotto.utils;

public enum ErrorMessage {
    INVALID_LOTTO_PAYMENT("로또 구입 금액은 1000원 이상이어야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_INPUT("숫자를 입력해 주세요."),
    INVALID_WINNING_NUMBERS("당첨 번호는 1,2,3,4,5,6 형식으로 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }

}
