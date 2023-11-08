package lotto.model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.utils.Rank;
import lotto.utils.StringParser;

public class WinningNumberChecker {
    private final List<Integer> winningNumber;
    private final int bonus;
    private final Lottos lottos;
    private Map<Rank, Integer> rankScore;

    public WinningNumberChecker(List<Integer> winningNumber, int bonus, Lottos lottos) {
        this.winningNumber = winningNumber;
        this.bonus = bonus;
        this.lottos = lottos;
        initRankScore();
    }

    public Map<Rank, Integer> getWinningRankResult() {
        return rankScore;
    }

    public void checkWinningRankResult() {
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            checkWinningRank(lotto);
        }
    }

    private void checkWinningRank(Lotto lotto) {
        int matchNumber = checkWinningNumbers(lotto);
        if (matchNumber == Rank.FIRST.getMatchNumberCount()) {
            rankScore.compute(Rank.FIRST, (k, v) -> v + 1);
        }
        if (matchNumber == Rank.SECOND.getMatchNumberCount() && isBonusCheck(lotto)) {
            rankScore.compute(Rank.SECOND, (k, v) -> v + 1);
        }
        if (matchNumber == Rank.THIRD.getMatchNumberCount() && !isBonusCheck(lotto)) {
            rankScore.compute(Rank.THIRD, (k, v) -> v + 1);
        }
        if (matchNumber == Rank.FOURTH.getMatchNumberCount()) {
            rankScore.compute(Rank.FOURTH, (k, v) -> v + 1);
        }
        if (matchNumber == Rank.FIFTH.getMatchNumberCount()) {
            rankScore.compute(Rank.FIFTH, (k, v) -> v + 1);
        }
    }

    private void initRankScore() {
        rankScore = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankScore.put(rank, 0);
        }
    }

    private boolean isBonusCheck(Lotto lotto) {
        return lotto.getLotto().contains(bonus);
    }

    private int checkWinningNumbers(Lotto lotto) {
        Set<Integer> winningSet = StringParser.parseListToSet(winningNumber);
        winningSet.retainAll(StringParser.parseListToSet(lotto.getLotto()));
        return winningSet.size();
    }
}
