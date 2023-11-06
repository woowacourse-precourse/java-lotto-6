package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aggregator {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public Aggregator(List<Integer> winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
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
        if (count == 5 && isSecondRank(lotto))
            return Rule.SECOND_RANK.value();
        return count;
    }

    private boolean isSecondRank(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
