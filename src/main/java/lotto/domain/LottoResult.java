package lotto.domain;

import lotto.type.LottoPrize;
public class LottoResult {
    private final Lotto winningNumbers;
    private int countMatchingNumbers(Lotto lotto) {
        return winningNumbers.getNumbers().stream()
                .filter(lotto.getNumbers()::contains)
                .toList()
                .size();
    }
}