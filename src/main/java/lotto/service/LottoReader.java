package lotto.service;

import java.util.List;
import lotto.domain.Lotto;

public class LottoReader {

    private final Lotto lotto;
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private int matchCount;
    private boolean bonusMatch;

    public LottoReader(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        this.matchCount = 0;
        this.bonusMatch = false;
        this.lotto = lotto;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        match();
    }

    private void match() {
        List<Integer> numbers = lotto.getNumbers();
        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
            if (number == bonusNumber) {
                bonusMatch = true;
            }
        }
    }

    public Integer getRank() throws IllegalArgumentException {
        if (matchCount < 3 && matchCount >= 0) {
            return null;
        }
        if (matchCount == 3) {
            return 5;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 5 && !bonusMatch) {
            return 3;
        }
        if (matchCount == 5 && bonusMatch) {
            return 2;
        }
        if (matchCount == 6) {
            return 1;
        }
        throw new IllegalArgumentException();
    }
}
