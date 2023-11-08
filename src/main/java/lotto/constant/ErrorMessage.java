package lotto.constant;

public enum ErrorMessage {
    NOT_POSITIVE("[ERROR] 입력이 양수여야 합니다."),
    NOT_THOUSAND_UNIT("[ERROR] 입력이 1000 단위여야 합니다."),
    NOT_NUMBER("[ERROR] 숫자만 입력해야 합니다."),
    LOTTO_RANGE("[ERROR] 로또 숫자 범위여야 합니다."),
    NUMBER_COUNT_OF_LOTTO("[ERROR] 숫자 개수가 로또 형식과 맞지 않습니다."),
    DELIMITER_FORMAT("[ERROR] 구분 형식이 올바르지 않습니다."),
    NUMBER_DUPLICATED("[ERROR] 중복된 숫자를 입력하면 안 됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}