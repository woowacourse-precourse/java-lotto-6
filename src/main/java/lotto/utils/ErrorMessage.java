package lotto.utils;

public enum ErrorMessage {
    DEPOSIT_NOT_A_NUMBER("[ERROR] 로또 구입 금액은 1,000원 이상, 100,000원 이하의 숫자여야 합니다. "),
    DEPOSIT_NOT_A_UNIT_OF_THOUSAND("[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다. "),
    DEPOSIT_OUT_OF_RANGE("[ERROR] 로또 구입 금액은 1,000원 이상, 100,000원 이하여야 합니다. "),
    WINNING_NUMBERS_NOT_A_NUMBER("[ERROR] 당첨 번호는 6개의 숫자여야 합니다. "),
    WINNING_NUMBERS_OUT_OF_RANGE_IN_LENGTH("[ERROR] 당첨 번호는 6개의 숫자여야 합니다. "),
    WINNING_NUMBERS_NOT_UNIQUE_NUMBER("[ERROR] 당첨 번호는 서로 다른 6개의 숫자여야 합니다. "),
    WINNING_NUMBERS_OUT_OF_RANGE_NUMBER("[ERROR] 당첨 번호는 1이상, 45이하의 숫자여야 합니다. "),
    BONUS_NUMBER_NOT_A_NUMBER("[ERROR] 보너스 번호는 6개의 숫자여야 합니다. "),
    BONUS_NUMBER_OUT_OF_RANGE_NUMBER("[ERROR] 보너스 번호는 1이상, 45이하의 숫자여야 합니다. "),
    BONUS_NUMBER_NOT_UNIQUE_NUMBER_FROM_WINNING_NUMBERS("[ERROR] 보너스 번호는 당첨 번호와 다른 숫자여야 합니다. ");


    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
