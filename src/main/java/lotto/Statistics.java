package lotto;

import java.util.HashMap;
import java.util.Map;

public class Statistics {
    private final Map<PrizeGrade, Integer> gradeDist;

    public Statistics(Lottos lottos, Lotto winningLotto, Bonus bonus) {
        this.gradeDist = getZeroDist();
        fillDist(lottos, winningLotto, bonus);
    }

    public Map<PrizeGrade, Integer> getGradeDist() {
        return this.gradeDist;
    }
}
