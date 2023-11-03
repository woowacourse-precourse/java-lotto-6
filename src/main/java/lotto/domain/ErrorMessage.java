package lotto.domain;

public enum ErrorMessage {
    INVALID_DELIMITER("[ERROR] 번호는 ',' 로 구분되어야 합니다."),
    INVALID_LOTTO_NUMBERS("[ERROR] 로또 번호는 숫자만 입력 가능합니다."),
    INVALID_NUMBER_RANGE("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_PURCHASE_AMOUNT_VALUE("[ERROR] 구입금액은 숫자만 입력 가능합니다."),
    INVALID_UNIT("[ERROR] 로또 구입 금액은 1000원 단위어야 합니다."),
    DUPLICATED_BONUS_NUMBER("[ERROR] 당첨 번호와 중복된 번호를 입력할 수 없습니다."),
    DUPLICATED_NUMBER("[ERROR] 당첨 번호로 중복된 수를 입력할 수 없습니다."),
    EXACTLY_ONE_NUMBER("[ERROR] 하나의 수만 입력해야 합니다."),
    NOT_INTEGER("[ERROR] 정수 값만 입력 가능합니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
