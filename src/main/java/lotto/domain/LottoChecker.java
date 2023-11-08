package lotto.domain;

import java.util.List;

public class LottoChecker {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoChecker(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Ranking checkOneLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getNumbers();

        int matchingCount = 0;
        for (Integer number : lottoNumbers) {
            matchingCount += isMatchingNumber(number);
        }
        boolean isContainBonus = isBonusMatch(lottoNumbers);
    }

    private int isMatchingNumber(int number) {
        if (winningNumbers.contains(number) || number == bonusNumber) {
            return 1;
        }
        return 0;
    }

    private boolean isBonusMatch(List<Integer> numbers) {
        for (Integer i : numbers) {
            if (i == bonusNumber) {
                return true;
            }
        }
        return false;
    }
}
