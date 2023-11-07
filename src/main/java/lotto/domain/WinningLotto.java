package lotto.domain;


import java.util.List;

import static lotto.constants.DomainConstants.MATCHING_COUNT;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Integer countCorrectNumbers(Lotto lotto) {
        Integer matchingNumber = MATCHING_COUNT;

        for (Integer number : lotto.getNumbers()) {
            if (hasWinningNumberAndBonusNumber(number)) {
                matchingNumber ++;
            }
        }

        return matchingNumber;
    }

    private boolean hasWinningNumberAndBonusNumber(Integer number) {
        return winningNumbers.contains(number) && !number.equals(bonusNumber.getNumber());
    }

    public Boolean isCorrectBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }
}
