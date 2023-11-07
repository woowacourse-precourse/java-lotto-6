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

    private Map<PrizeGrade, Integer> getZeroDist() {
        Map<PrizeGrade, Integer> zeroDist = new HashMap<>();
        for (PrizeGrade prizeGrade : PrizeGrade.values()) {
            zeroDist.put(prizeGrade, ZERO);
        }
        return zeroDist;
    }

    private void fillDist(Lottos lottos, Lotto winningLotto, Bonus bonus) {
        for (Lotto lotto : lottos.getTickets()) {
            addFrequency(determineGrade(lotto, winningLotto, bonus));
        }
    }
}
