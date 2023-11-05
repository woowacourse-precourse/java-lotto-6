package lotto.service;

public enum UserNumbersValidateEnum {
    PRE_NUMBERS_ERROR("[ERROR] 숫자만 입력 가능합니다."),
    PRE_NUMBERS_DELIMITER_ERROR("[ERROR] 구분자와 숫자만 입력 가능합니다."),
    LOTTO_NUMBERS_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBERS_DUPLICATE_ERROR("[ERROR] 로또 번호는 중복이 불가능합니다."),
    LOTTO_NUMBERS_SIZE_ERROR("[ERROR] 로또 번호는 6개만 가능합니다."),
    DUPLICATE_NUMBERS_BONUS_ERROR("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");

    private String message;

    UserNumbersValidateEnum(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
