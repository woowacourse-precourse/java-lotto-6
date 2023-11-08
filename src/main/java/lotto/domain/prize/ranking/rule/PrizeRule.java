package lotto.domain.prize.ranking.rule;

import lotto.domain.lotto.Lotto;
import lotto.domain.prize.Prize;

public interface PrizeRule {
    boolean test(final Lotto lotto, final Prize prize);
}
