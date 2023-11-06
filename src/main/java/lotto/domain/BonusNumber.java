package lotto.domain;

import static lotto.constant.LottoNumber.MAXIMUM_LOTTO_NUMBER;
import static lotto.constant.LottoNumber.MINIMUM_LOTTO_NUMBER;
import static lotto.constant.message.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.constant.message.ErrorMessage.INVALID_RANGE_BONUS_NUMBER;
import static lotto.constant.message.ErrorMessage.NON_INTEGER_BONUS_NUMBER;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String number, List<Integer> winningNumbers) {
        this.bonusNumber = validateBonusNumber(number, winningNumbers);
    }

    private int validateBonusNumber(String number, List<Integer> winningNumbers) {
        checkValidInteger(number);
        checkDuplicateWithWinningNumber(number, winningNumbers);
        checkNumberRange(number);

        return Integer.parseInt(number);
    }

    private void checkValidInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(NON_INTEGER_BONUS_NUMBER.getMessage());
        }
    }

    private void checkDuplicateWithWinningNumber(String number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(Integer.parseInt(number))) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER.getMessage());
        }
    }

    private void checkNumberRange(String number) {
        if (Integer.parseInt(number) < MINIMUM_LOTTO_NUMBER.getNumber()
                || Integer.parseInt(number) > MAXIMUM_LOTTO_NUMBER.getNumber()) {
            throw new IllegalArgumentException(INVALID_RANGE_BONUS_NUMBER.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
