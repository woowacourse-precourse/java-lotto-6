package lotto.Domain;

import java.util.function.Predicate;
import lotto.Lotto;
import lotto.Utils.Rank;
import lotto.Utils.SystemConstants;

public class Calculator {
    public int totalPrize = 0;

    public int matchCount(Lotto userLotto, Lotto winningLotto) {
        var matchList = userLotto.getNumbers().stream()
                .filter(o -> winningLotto.getNumbers().stream().anyMatch(Predicate.isEqual(o))).toList();

        return matchList.size();
    }

    public boolean containBonus(Lotto comparableLotto, int bonus) {
        return comparableLotto.getNumbers().contains(bonus);
    }

    public void addPrize(Rank rank) {
        totalPrize += Rank.getPrize(rank);
    }

    public String calculateYield(int purchaseAmount) {
        var yield = (double) totalPrize / (double) purchaseAmount * 100;

        return String.format(SystemConstants.ROUND_TO_TWO, yield);
    }
}
