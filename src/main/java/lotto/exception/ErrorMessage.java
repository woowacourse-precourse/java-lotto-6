package lotto.exception;

import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.validator.WinningLottoValidator;

public enum ErrorMessage {

    ENTER_VALUE_MESSAGE("값을 입력해 주세요."), INVALID_INPUT_CHARACTER_MESSAGE(
            "알맞은 숫자를 입력해주세요."), PURCHASE_AMOUNT_IS_ZERO_MESSAGE(
            "구입 금액은 0이 될 수 없습니다."), PURCHASE_AMOUNT_NOT_DIVISIBLE_MESSAGE(
            "구입 금액은 " + PurchaseAmount.PURCHASE_AMOUNT_UNIT
                    + "단위로 입력해 주세요."), ENTER_NUMBERS_AND_DELIMITERS_ONLY_MESSAGE(
            "당첨 번호는 자연수와 '" + WinningLottoValidator.DELIMITER
                    + "'만을 사용하여 입력해주세요."), INVALID_LOTTO_WINNING_NUMBER_RANGE_MESSAGE(
            "당첨 번호를 " + Lotto.MIN_LOTTO_NUMBER + " ~ " + Lotto.MAX_LOTTO_NUMBER
                    + " 사이의 숫자로 입력해주세요."), INVALID_LOTTO_SIZE_MESSAGE(
            "당첨 번호는 " + Lotto.SIZE + "개 입니다."), DUPLICATE_NUMBERS_MESSAGE(
            "당첨 번호는 중복되지 않아야 합니다"), INVALID_LOTTO_BONUS_NUMBER_RANGE_MESSAGE(
            "보너스 번호를 " + Lotto.MIN_LOTTO_NUMBER + " ~ " + Lotto.MAX_LOTTO_NUMBER
                    + " 사이의 숫자로 입력해주세요."), DUPLICATE_NUMBER_MESSAGE("보너스 숫자로 당첨 숫자와 중복된 값이 입력됐습니다.");

    private final String ERROR_FORMAT = "[ERROR]: ";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_FORMAT + message + "\n";
    }
}
