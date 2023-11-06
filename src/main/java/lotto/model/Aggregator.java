package lotto.model;

import java.util.List;

public class Aggregator {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;
    private final WinningResult winningResult;

    public Aggregator(List<Integer> winningNumbers, int bonusNumber, WinningResult winningResult) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
        this.winningResult = winningResult;
    }

    public List<Integer> result(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::countMatch)
                .toList();
    }

    private int countMatch(Lotto lotto) {
        int count = (int) lotto.getNumbers()
                .stream()
                .filter(winningNumbers::contains)
                .count();
        return winningResult.determineCountByBonus(count, isBonusHit(lotto));
    }

    private boolean isBonusHit(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
