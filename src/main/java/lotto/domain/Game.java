package lotto.domain;

import java.util.List;
import lotto.validation.Validation;

public class Game {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public Game(List<Integer> winningNumbers, int bonusNumber) {
        validateWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

//    public List<Integer> getWinningNumbers() {
//        return this.winningNumbers;
//    }
//
//    public int getBonusNumber() {
//        return this.bonusNumber;
//    }

    private void validateWinningNumbers(List<Integer> winningNumbers) {
        Validation.validateListOutOfRangeNumber(winningNumbers);
    }


    private void validateBonusNumber(int bonusNumber) {
        Validation.validateListContainsNumber(this.winningNumbers, bonusNumber);
        Validation.validateOutOfRangeNumber(bonusNumber);
    }
}
