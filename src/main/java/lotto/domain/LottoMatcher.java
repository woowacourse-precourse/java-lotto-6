package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoMatcher {

    private final WinningNumbers winningNumbers;

    public LottoMatcher(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> countMatchedNumbersForLottoTickets(List<Lotto> lottoTickets) {
        List<Integer> matchedCounts = new ArrayList<>();
        for (Lotto lotto : lottoTickets) {
            matchedCounts.add(countMatchedNumbers(lotto));
        }

        return matchedCounts;
    }

    private int countMatchedNumbers(Lotto lotto) {
        return (int) winningNumbers.drawnNumbers().stream()
            .filter(lotto.getNumbers()::contains)
            .count();
    }
}
