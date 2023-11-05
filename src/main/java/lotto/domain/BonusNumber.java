package lotto.domain;

import static lotto.constant.message.ErrorMessage.DUPLICATE_BONUS_NUMBER;
import static lotto.constant.message.ErrorMessage.NON_INTEGER_BONUS_NUMBER;

import java.util.List;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(String number, List<Integer> winningNumbers) {
        this.bonusNumber = validateBonusNumber(number, winningNumbers);
    }

    private int validateBonusNumber(String number, List<Integer> winningNumbers) {

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
}
