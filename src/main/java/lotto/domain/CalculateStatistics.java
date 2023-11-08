package lotto.domain;

import java.util.List;
import lotto.data.Lotto;
import lotto.data.Statics;
import lotto.data.Winning;

public class CalculateStatistics {
    public static void calculateStatistics(List<Lotto> lottos, Winning winning, Statics statics) {
        for (Lotto lotto : lottos) {
            int matchCount = winning.match(lotto);
            boolean hasBonus = winning.isBonusMatch(lotto);
            statics.recordResult(matchCount, hasBonus);
        }
    }
}
