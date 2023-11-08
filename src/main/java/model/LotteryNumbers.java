package model;

import message.ErrorMessage;
import lotto.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LotteryNumbers {
    private final Lotto lotteryNumbers;
    private final Integer bonusNumber;

    public LotteryNumbers(List<Integer> lotteryNumbers, Integer bonusNumber) {
        this.lotteryNumbers = new Lotto(lotteryNumbers);

        validateBonusNumber(lotteryNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> lotteryNumbers, Integer bonusNumber) {
        validateSameBonusNumber(lotteryNumbers, bonusNumber);
        validateBonusNumberRange(bonusNumber);
    }

    private void validateSameBonusNumber(List<Integer> lotteryNumbers, Integer number) {
        Set<Integer> numbers = new HashSet<>(lotteryNumbers);
        numbers.add(number);
        if (numbers.size() != 7) {
            throw new IllegalArgumentException(ErrorMessage.SAME_BONUS_NUMBER_ERROR);
        }
    }

    private void validateBonusNumberRange(Integer bonusNumber) {
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_RANGE_ERROR);
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean isContain(int number) {
        return lotteryNumbers.isContain(number);
    }
}