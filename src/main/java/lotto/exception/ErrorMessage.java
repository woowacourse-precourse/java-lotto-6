package lotto.exception;

import static lotto.constants.LottoConstants.*;

public enum ErrorMessage {
    ERROR_PREFIX("[ERROR] "),
    INVALID_INPUT_NOT_NUMERIC("숫자를 입력해주세요."),

    //구입금액
    PURCHASE_AMOUNT_NEGATIVE(String.format("%d 단위의 양수를 입력해주세요.", LOTTO_PRICE)),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE(String.format("%d 으로 나누어 떨어지는 수를 입력해주세요", LOTTO_PRICE)),

    //로또 번호
    INPUT_INVALID_RANGE(String.format("%d 이상 %d 이하의 숫자를 입력해주세요.", MINIMUM_RANGE, MAXIMUM_RANGE)),
    LOTTO_NUMBERS_DUPLICATED(String.format("서로 다른 %d개 숫자만 가능합니다.", NUMBERS_SIZE)),
    LOTTO_NUMBERS_INVALID_SIZE(String.format("로또 숫자는 %d개만 가능합니다.", NUMBERS_SIZE)),
    WINNING_NUMBERS_BLANK(String.format("당첨번호 %d개를 입력해주세요.", NUMBERS_SIZE)),
    WINNING_NUMBERS_STARTS_OR_ENDS_WITH_DELIMITER(String.format("당첨번호 %d개를 쉼표로 구분하여 입력해주세요.", NUMBERS_SIZE)),
    WINNING_NUMBERS_NOT_NUMERIC(String.format("당첨번호로 %d개의 숫자를 입력해주세요.", NUMBERS_SIZE)),
    BONUS_NUMBER_DUPLICATED("보너스 번호는 당첨번호와 중복되지 않는 숫자로 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_PREFIX.message + message;
    }
}
