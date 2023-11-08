package lotto.model;

import java.util.List;

public class Aggregator {
    private final DrawNumbers drawNumbers;

    public Aggregator(DrawNumbers drawNumbers) throws IllegalArgumentException {
        this.drawNumbers = drawNumbers;
    }

    public List<Integer> matchResult(List<Lotto> lottos) {
        return lottos.stream()
                .map(this::countMatch)
                .toList();
    }

    private int countMatch(Lotto lotto) {
        int count = (int) lotto.getNumbers()
                .stream()
                .filter(drawNumbers.getWinningNumbers()::contains)
                .count();
        return WinningResult.determineRankByBonus(count, isBonusHit(lotto));
    }

    private boolean isBonusHit(Lotto lotto) {
        return lotto.getNumbers().contains(drawNumbers.getBonusNumber());
    }
}
