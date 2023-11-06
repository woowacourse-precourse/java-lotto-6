package lotto.domain;

public enum LottoNumbersValidateStatus {
    LOTTO_NUMBERS_VALIDATE("^[0-9,]*$"),
    LOTTO_NUMBERS_SIZE_ERROR("[ERROR] 로또 번호는 6개만 입력 가능합니다."),
    LOTTO_NUMBERS_DUPLICATE_ERROR("[ERROR] 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBERS_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBERS_TYPE_ERROR("[ERROR] 로또 번호는 숫자만 입력 가능합니다.");

    private String message;

    LottoNumbersValidateStatus(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
