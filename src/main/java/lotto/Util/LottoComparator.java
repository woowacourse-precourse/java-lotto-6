package lotto.Util;

import java.util.function.Predicate;
import lotto.Domain.Bonus;
import lotto.Domain.Lotto;

public class LottoComparator {

    public static int getMatchCount(Lotto lotto, Lotto userLotto) {
        return (int) lotto.getNumbers().stream().filter(l -> userLotto.getNumbers().stream()
                .anyMatch(Predicate.isEqual(l))).count();
    }

    public static boolean getMatchBonus(Lotto lotto, Bonus bonus) {
        return lotto.getNumbers().contains(bonus.getBonus());
    }
}
