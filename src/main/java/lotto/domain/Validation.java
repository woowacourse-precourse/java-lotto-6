package lotto.domain;

import static lotto.constant.LottoNumber.LOTTO_NUMBER_LENGTH;
import static lotto.constant.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoNumber.MINIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoNumber.PURCHASE_UNIT;
import static lotto.constant.LottoNumber.ZERO;
import static lotto.constant.message.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.constant.message.ErrorMessage.DUPLICATE_NUMBER;
import static lotto.constant.message.ErrorMessage.INVALID_LENGTH_LOTTO_NUMBER;
import static lotto.constant.message.ErrorMessage.INVALID_RANGE_NUMBER;
import static lotto.constant.message.ErrorMessage.NON_INTEGER;
import static lotto.constant.message.ErrorMessage.NOT_PURCHASE_UNIT;

import java.util.List;

public abstract class Validation {
    void checkValidInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_INTEGER.getMessage());
        }
    }

    void checkNumberRange(String number) {
        if (Integer.parseInt(number) < MINIMUM_LOTTO_NUMBER.getNumber()
                || Integer.parseInt(number) > MAXIMUM_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(INVALID_RANGE_NUMBER.getMessage());
        }
    }

    void checkDuplicateWithWinningNumber(String number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(Integer.parseInt(number))) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    void checkNumbersLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH.getNumber()) {
            throw new IllegalArgumentException(INVALID_LENGTH_LOTTO_NUMBER.getMessage());
        }
    }

    void checkNumbersDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_LENGTH.getNumber()) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER.getMessage());
        }
    }

    void checkDivideByThousand(String money) {
        if (Integer.parseInt(money) <= ZERO.getNumber() || Integer.parseInt(money) % PURCHASE_UNIT.getNumber() != ZERO.getNumber()) {
            throw new IllegalArgumentException(NOT_PURCHASE_UNIT.getMessage());
        }
    }
}
