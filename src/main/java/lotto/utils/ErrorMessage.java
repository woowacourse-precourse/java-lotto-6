package lotto.utils;

public enum ErrorMessage {
    // 구입금액 관련 에러
    INPUT_MONEY_BELOW_MIN_AMOUNT_ERROR("[ERROR] 최소 1000원을 입력해야합니다."),
    INPUT_MONEY_ABOVE_MAX_AMOUNT_ERROR("[ERROR] 최대 100,000,000원을 입력해야합니다."),
    INPUT_MONEY_NOT_DIVISIBLE_ERROR("[ERROR] 1000원 단위의 값을 입력해야합니다."),
    INPUT_MONEY_NOT_INTEGER_ERROR("[ERROR] 정수만 입력 가능합니다."),

    // 로또 관련 에러
    LOTTO_NUMBER_COUNT_INVALID_ERROR("[ERROR] 로또 번호가 6개가 아닌 경우가 발생하여, 로또 번호를 다시 생성합니다."),
    LOTTO_NUMBER_RANGE_INVALID_ERROR("[ERROR] 로또 번호가 1부터 45 사이의 숫자가 아닌 경우가 발생하여, 로또 번호를 다시 생성합니다."),
    LOTTO_NUMBER_DUPLICATION_ERROR("[ERROR] 로또 번호에 중복된 숫자가 포함된 경우가 발생하여, 로또 번호를 다시 생성합니다."),

    // 당첨번호 관련 에러
    WINNING_NUMBER_COUNT_INVALID_ERROR("[ERROR] 당첨 번호는 6개여야 합니다."),
    WINNING_NUMBER_RANGE_INVALID_ERROR("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다."),
    WINNING_NUMBER_DUPLICATION_ERROR("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    WINNING_NUMBER_NOT_INTEGER_ERROR("[ERROR] 입력값은 모두 정수여야 합니다."),

    // 보너스 숫자 관련 에러
    BONUS_NUMBER_RANGE_INVALID_ERROR("[ERROR] 보너스 숫자는 1부터 45 사이어야 합니다."),
    BONUS_NUMBER_NOT_INTEGER_ERROR("[ERROR] 보너스 번호는 오로지 정수여야 합니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
