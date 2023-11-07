package lotto;

public enum ErrorCode {
    INVALID_LOTTO_NUMBER_COUNT("[ERROR] 로또 번호의 개수는 6개입니다.\n"),
    INVALID_LOTTO_NUMBER_DUPLICATE("[ERROR] 로또 번호: 중복되면 안 됩니다."),
    INVALID_LOTTO_NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호: 1~45 숫자만 가능합니다.")
    ;

    private final String value;

    ErrorCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
