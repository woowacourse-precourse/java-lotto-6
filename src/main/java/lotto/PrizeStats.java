package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrizeStats {
    private final Map<PrizeGrade, Integer> gradeDist;

    public PrizeStats(List<Lotto> lottos, Lotto winningLotto, Bonus bonus) {
        this.gradeDist = getEmptyDist();
        fillDist(lottos, winningLotto, bonus);
    }

    public Map<PrizeGrade, Integer> getGradeDist() {
        return this.gradeDist;
    }

    private Map<PrizeGrade, Integer> getEmptyDist() {
        Map<PrizeGrade, Integer> zeroDist = new HashMap<>();
        for (PrizeGrade prizeGrade : PrizeGrade.values()) {
            zeroDist.put(prizeGrade, ZERO);
        }
        return zeroDist;
    }

    private void fillDist(List<Lotto> lottos, Lotto winningLotto, Bonus bonus) {
        for (Lotto lotto : lottos) {
            addFrequency(determineGrade(lotto, winningLotto, bonus));
        }
    }

    private PrizeGrade determineGrade(Lotto lotto, Lotto winningLotto, Bonus bonus) {
        return PrizeGrade.of(lotto.countMatches(winningLotto), lotto.matchWithBonus(bonus));
    }

    private void addFrequency(PrizeGrade prizeGrade) {
        gradeDist.put(prizeGrade, Integer.valueOf(gradeDist.get(prizeGrade) + 1));
    }
}
