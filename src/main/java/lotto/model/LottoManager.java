package lotto.model;

import java.util.*;

import static lotto.model.ErrorConstants.*;
import static lotto.model.LottoConstants.*;

public class LottoManager {
    private final List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoManager(List<Integer> winningNumbers) {
        validateWinningNumbersRange(winningNumbers);
        validateWinningNumbers(winningNumbers);
        validateNoDuplicateNumbers(winningNumbers);
        this.winningNumbers = new ArrayList<>(winningNumbers);
    }

    private void validateWinningNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format(WINNING_NUMBER_ERROR, LOTTO_NUMBER_COUNT));
        }
    }

    private void validateWinningNumbersRange(List<Integer> numbers) {
        boolean isOutOfRange = numbers.stream().anyMatch(number -> number < LOTTO_START_NUMBER || number > LOTTO_END_NUMBER);
        if (isOutOfRange) {
            throw new IllegalArgumentException(String.format(LOTTO_NUMBER_RANGE_ERROR, LOTTO_START_NUMBER, LOTTO_END_NUMBER));
        }
    }

    private void validateNoDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(WINNING_NUMBER_DUPLICATE_ERROR);
        }
    }

    private void validateNoDuplicateBonusNumber(int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_AND_WINNING_NUMBER_ERROR);
        }
        this.bonusNumber = bonusNumber;
    }

    private static void validateBonusNumberRange(int bonusNumber) {
        boolean isOutOfRange = bonusNumber < LOTTO_START_NUMBER || bonusNumber > LOTTO_END_NUMBER;
        if (isOutOfRange) {
            throw new IllegalArgumentException(String.format(BONUS_NUMBER_RANGE_ERROR,
                    LOTTO_START_NUMBER, LOTTO_END_NUMBER));
        }
    }

    public void addBonusNumber(int bonusNumber) {
        validateBonusNumberRange(bonusNumber);
        validateNoDuplicateBonusNumber(bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
