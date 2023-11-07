package lotto.domain;


import lotto.exception.DuplicateInputException;

import java.util.List;

import static lotto.constants.DomainConstants.MATCHING_COUNT;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        if (hasDuplicatedNumber(winningNumbers, bonusNumber)) {
            throw new DuplicateInputException();
        }
    }

    private Boolean hasDuplicatedNumber(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        return winningNumbers.contains(bonusNumber.getNumber());
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
