package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.exception.NotDuplicatedLottoNumberException;

public class LottoNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoNumbers(List<Integer> winningNumbers, int bonusNumber) {
        checkIsDuplicatedNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void checkIsDuplicatedNumber(List<Integer> winningNumbers, int bonusNumber) {
        Set<Integer> uniqueNumbers = new HashSet<>(winningNumbers);
        uniqueNumbers.add(bonusNumber);

        if (uniqueNumbers.size() != winningNumbers.size() + 1) {
            throw new NotDuplicatedLottoNumberException();
        }
    }

    public List<Integer> getWinningNumbers() {
        return new ArrayList<>(winningNumbers);
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
