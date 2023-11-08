package io.message;

public enum InputErrorMessage {
    NOT_INTEGER("정수를 입력해주세요."),
    NOT_MULTIPLE_OF_PRICE("1000원 단위로 입력해주세요."),
    INVALID_LOTTO_SIZE("로또 번호의 개수는 6개여야 합니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),
    DUPLICATED_BONUS_NUMBER("보너스 번호는 로또 번호와 중복될 수 없습니다."),
    BELOW_MIN_PURCHASE_AMOUNT("최소 구입 금액은 1000원입니다.");

    private final String message;

    InputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
