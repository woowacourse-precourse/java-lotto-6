package lotto.domain;


import java.util.List;

public class WinningLotto {
    private final List<Integer> winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Integer countCorrectNumbers(Lotto lotto) {
        Integer matchingNumber = 0;

        for (Integer numbers : lotto.getNumbers()) {
            if (winningNumbers.contains(numbers)) {
                matchingNumber ++;
            }
        }

        return matchingNumber;
    }

    public Boolean isCorrectBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }
}
