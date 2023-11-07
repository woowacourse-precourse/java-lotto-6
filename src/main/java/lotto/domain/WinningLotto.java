package lotto.domain;


import lotto.exception.DuplicateInputException;
import lotto.exception.InvalidInputException;

import java.util.List;

import static lotto.utils.constants.WinningLottoConstants.*;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Integer countNumbers(Lotto lotto) {
        Integer matchingNumbers = 0;

        for (Integer numbers : lotto.getNumbers()) {
            if (winningNumbers.contains(numbers)) {
                matchingNumbers ++;
            }
        }

        return matchingNumbers;
    }

    public Boolean isCorrectBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }
}
