package lotto;

import java.util.List;
import java.util.TreeMap;

public class PrizeStats {
    private final TreeMap<PrizeGrade, Integer> gradeDist;

    public PrizeStats(List<Lotto> lottos, Lotto winningLotto, Bonus bonus) {
        this.gradeDist = getEmptyDist();
        fillDist(lottos, winningLotto, bonus);
    }

    public TreeMap<PrizeGrade, Integer> getGradeDist() {
        return this.gradeDist;
    }

    private TreeMap<PrizeGrade, Integer> getEmptyDist() {
        TreeMap<PrizeGrade, Integer> zeroDist = new TreeMap<>();
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
        gradeDist.put(prizeGrade, gradeDist.get(prizeGrade) + 1);
    }
}
