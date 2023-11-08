package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public LottoNumbers(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumbers() {
        return new ArrayList<>(winningNumbers);
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }
}
