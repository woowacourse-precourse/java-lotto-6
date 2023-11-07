package lotto.view;

public enum ErrorConstants {
    INDIVISIBLE_BUY_AMOUNT_ERROR_MESSAGE("[ERROR] 구입 금액은 %d의 배수여야 합니다."),
    MINIMUM_BUY_AMOUNT_ERROR_MESSAGE("[ERROR] 구입할 로또 개수는 최소 %d개 이상이어야 합니다."),
    OUT_OF_RANGE_NUMBER_ERROR_MESSAGE("[ERROR] 로또 번호는 %d-%d 범위 내의 자연수여야 합니다."),
    INVALID_LENGTH_ERROR_MESSAGE("[ERROR] 로또는 %d개의 숫자로 구성되어야 합니다."),
    DUPLICATED_WINNING_NUMBERS_ERROR_MESSAGE("[ERROR] 당첨 번호에 중복된 숫자가 존재합니다."),
    DUPLICATED_LOTTO_NUMBERS_ERROR_MESSAGE("[ERROR] 생성된 로또에 중복된 숫자가 존재합니다."),
    DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE("[ERROR] 보너스 번호는 우승 번호의 숫자와 중복될 수 없습니다.");

    private final String message;

    ErrorConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
