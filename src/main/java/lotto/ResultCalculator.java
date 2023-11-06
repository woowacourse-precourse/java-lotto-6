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
        int matchCount = countMatchingNumbers(lotto, winningLotto);
        boolean bonusMatch = matchWithBonus(lotto, bonus);

        int number = LOTTO_SIZE;
        if (matchCount == number--) {
            return PrizeGrade.FIRST;
        }
        if (matchCount == number-- && bonusMatch) {
            return PrizeGrade.SECOND;
        }
        if (matchCount == number) {
            return PrizeGrade.THIRD;
        }
        if (matchCount == number--) {
            return PrizeGrade.FOURTH;
        }
        if (matchCount == number--) {
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
