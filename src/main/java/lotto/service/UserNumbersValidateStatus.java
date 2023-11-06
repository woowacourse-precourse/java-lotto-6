package lotto.service;

public enum UserNumbersValidateStatus {
    PRE_NUMBERS_ERROR("[ERROR] 숫자만 입력 가능합니다."),
    PRE_NUMBERS_DELIMITER_ERROR("[ERROR] 구분자와 숫자만 입력 가능합니다."),
    DELIMITER_START_END_ERROR("[ERROR] 구분자로 시작하거나 끝날 수 없습니다."),
    DELIMITER_DOUBLE_ERROR("[ERROR] 구분자는 연속으로 올 수 없습니다."),
    LOTTO_NUMBERS_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBERS_DUPLICATE_ERROR("[ERROR] 로또 번호는 중복이 불가능합니다."),
    LOTTO_NUMBERS_SIZE_ERROR("[ERROR] 로또 번호는 6개만 가능합니다."),
    DUPLICATE_NUMBERS_BONUS_ERROR("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다.");

    private String message;

    UserNumbersValidateStatus(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
