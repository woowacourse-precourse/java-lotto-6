package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.config.Constant;

public class WinningNumbers {

    private final List<Integer> winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        Set<Integer> inputSet = new HashSet<>(winningNumbers);
        if (inputSet.size() != winningNumbers.size()) {
            throw new IllegalArgumentException(Constant.DUPLICATE_NUMBER_EXCEPTION);
        }
        if (winningNumbers.size() != Constant.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(Constant.NUMBER_SIZE_EXCEPTION);
        }
        for (int number : winningNumbers) {
            if (number < Constant.MIN_LOTTO_NUMBER || number > Constant.MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException(Constant.NUMBER_RANGE_EXCEPTION);
            }
        }
        if (winningNumbers.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(Constant.DUPLICATE_NUMBER_EXCEPTION);
        }
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}
