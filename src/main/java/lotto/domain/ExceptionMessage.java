package lotto.domain;

public enum ExceptionMessage {
    NULL_INPUT("입력 값에 null이 포함되어 있습니다. 다시 입력해주세요."),
    INVALID_NUMBER("유효하지 않은 숫자 형식입니다. 다시 입력해주세요."),
    INPUT_NEGATIVE_AMOUNT("구매 금액을 1,000원 이상이어야 합니다. 다시 입력해주세요."),
    NOT_MULTIPLE_OF_THOUSAND("입력값은 1,000원 단위로 입력되어야 합니다. 다시 입력해주세요."),
    INVALID_LOTTO_WINNING_SIZE("로또 번호는 6개여야 합니다. 다시 입력해주세요."),
    INVALID_LOTTO_BONUS_SIZE("보너스 번호는 1개여야 합니다. 다시 입력해주세요."),
    OUT_OF_RANGE("로또 번호는 1에서 45 사이의 수여야 합니다. 다시 입력해주세요."),
    LOTTO_NUMBER_DUPLICATES("로또 번호에 중복된 값이 있습니다. 다시 입력해주세요."),
    BONUS_NUMBER_DUPLICATES("보너스 넘버가 로또 넘버와 중복됩니다. 다시 입력해주세요.");

    private final String message;
    private static final String errorTag = "[ERROR]: ";

    ExceptionMessage(String message) {
        this.message = errorTag + message;
    }

    public String getMessage() {
        return message;
    }

    public void throwException() {
        throw new IllegalArgumentException(message);
    }
}