package lotto;

import java.util.HashMap;
import java.util.Map;

public class ResultCalculator {
    private final Map<Lotto, PrizeGrade> result;

    public ResultCalculator(Lottos lottos, Lotto winningLotto, Bonus bonus) {
        Map<Lotto, PrizeGrade> result = new HashMap<>();
        lottos.getTickets().stream()
                .forEach(lotto -> result.put(lotto, compare(lotto, winningLotto, bonus)));
        this.result = result;
    }
    private PrizeGrade compare(Lotto lotto, Lotto winningLotto, Bonus bonus) {
        int matches = countMatchingNumbers(lotto, winningLotto);
        boolean bonusMatch = matchWithBonus(lotto, bonus);

        if (matches == PrizeGrade.FIRST.getMatchCount()) {
            return PrizeGrade.FIRST;
        }
        if (matches == PrizeGrade.SECOND.getMatchCount() && bonusMatch) {
            return PrizeGrade.SECOND;
        }
        if (matches == PrizeGrade.THIRD.getMatchCount()) {
            return PrizeGrade.THIRD;
        }
        if (matches == PrizeGrade.FOURTH.getMatchCount()) {
            return PrizeGrade.FOURTH;
        }
        if (matches == PrizeGrade.FIFTH.getMatchCount()) {
            return PrizeGrade.FIFTH;
        }
        return PrizeGrade.NO_PRIZE;
    }

    private int countMatchingNumbers(Lotto lotto, Lotto winningLotto) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningLotto.getNumbers().contains(number))
                .count();
    }

    private boolean matchWithBonus(Lotto lotto, Bonus bonus) {
        return lotto.getNumbers().contains(bonus.getNumber());
    }
}
