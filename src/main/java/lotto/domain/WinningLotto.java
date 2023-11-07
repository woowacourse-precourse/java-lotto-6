package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final LottoNumber numbers;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.numbers = new LottoNumber(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        int matchCount = lotto.matchNumbers(numbers);
        boolean matchBonusNumber = lotto.containsBonusNumber(bonusNumber);
        return Rank.from(matchCount, matchBonusNumber);
    }
}

