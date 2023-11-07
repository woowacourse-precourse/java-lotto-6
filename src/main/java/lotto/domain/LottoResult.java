package lotto.domain;

import lotto.type.LottoPrize;
public class LottoResult {
    private final Lotto winningNumbers;
    private final int bonusNumber;
    private int countMatchingNumbers(Lotto lotto) {
        return winningNumbers.getNumbers().stream()
                .filter(lotto.getNumbers()::contains)
                .toList()
                .size();
    }

    private boolean isMatchBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}