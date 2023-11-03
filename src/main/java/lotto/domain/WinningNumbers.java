package lotto.domain;

import static lotto.constant.LottoInformation.MAX_NUMBER;
import static lotto.constant.LottoInformation.MIN_NUMBER;
import static lotto.constant.message.ErrorMessage.DUPLICATE_BONUS;
import static lotto.constant.message.ErrorMessage.INVALID_NUMBER_RANGE;
import static lotto.constant.message.ErrorMessage.NOT_ONLY_DIGIT;

import java.util.List;

public class WinningNumbers {
    private List<Integer> winningNumber;
    private int bonusNumber;

    public void makeWinningNumber(String input) {

    }

    public void makeBonusNumber(String input) throws IllegalArgumentException {
        int bonusNumber = convertNumber(input);
        validateBonusNumberRange(bonusNumber);
        validateDuplicateBonus(winningNumber, bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberRange(int bonusNumber) {
        if (!validRange(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_NUMBER_RANGE);
        }
    }

    private int convertNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NOT_ONLY_DIGIT);
        }
        return Integer.parseInt(input);
    }

    private boolean validRange(int number) {
        return number >= MIN_NUMBER && number <= MAX_NUMBER;
    }

    private void validateDuplicateBonus(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(DUPLICATE_BONUS);
        }
    }
}
