package lotto.domain;

import static lotto.constant.LottoNumber.LOTTO_NUMBER_LENGTH;
import static lotto.constant.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoNumber.MINIMUM_LOTTO_NUMBER;
import static lotto.constant.message.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.constant.message.ErrorMessage.DUPLICATE_WINNING_NUMBER;
import static lotto.constant.message.ErrorMessage.INVALID_LENGTH_WINNING_NUMBER;
import static lotto.constant.message.ErrorMessage.INVALID_RANGE_BONUS_NUMBER;
import static lotto.constant.message.ErrorMessage.NON_INTEGER_BONUS_NUMBER;

import java.util.List;

public abstract class Validation {
    void checkValidInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_INTEGER_BONUS_NUMBER.getMessage());
        }
    }

    void checkNumberRange(String number) {
        if (Integer.parseInt(number) < MINIMUM_LOTTO_NUMBER.getNumber()
                || Integer.parseInt(number) > MAXIMUM_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(INVALID_RANGE_BONUS_NUMBER.getMessage());
        }
    }

    void checkDuplicateWithWinningNumber(String number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(Integer.parseInt(number))) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    void checkNumbersLength(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_LENGTH.getNumber()) {
            throw new IllegalArgumentException(INVALID_LENGTH_WINNING_NUMBER.getMessage());
        }
    }

    void checkNumbersDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_LENGTH.getNumber()) {
            throw new IllegalArgumentException(DUPLICATE_WINNING_NUMBER.getMessage());
        }
    }
}
