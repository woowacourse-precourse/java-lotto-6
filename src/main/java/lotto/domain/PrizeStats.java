package lotto.domain;

import java.util.List;
import java.util.TreeMap;

import static lotto.constants.Numbers.*;

public class PrizeStats {
    private final TreeMap<PrizeGrade, Integer> gradeDist;

    public PrizeStats(List<Lotto> lottos, WinningNumbers winningNumbers) {
        this.gradeDist = getEmptyDist();
        fillDist(lottos, winningNumbers);
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

    private void fillDist(List<Lotto> lottos, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottos) {
            addFrequency(determineGrade(lotto, winningNumbers.getWinningLotto(), winningNumbers.getBonusNumber()));
        }
    }

    private PrizeGrade determineGrade(Lotto lotto, Lotto winningLotto, int bonusNumber) {
        return PrizeGrade.of(lotto.countMatches(winningLotto), lotto.matchWithBonus(bonusNumber));
    }

    private void addFrequency(PrizeGrade prizeGrade) {
        gradeDist.put(prizeGrade, gradeDist.get(prizeGrade) + ONE);
    }
}
