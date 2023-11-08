package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.utils.Rank;
import lotto.utils.StringParser;

public class WinningNumberChecker {
    private final List<Integer> winningNumber;
    private final int bonus;
    private final Lottos lottos;
    private Map<Rank, Integer> map = new HashMap<>();

    public WinningNumberChecker(List<Integer> winningNumber, int bonus, Lottos lottos) {
        this.winningNumber = winningNumber;
        this.bonus = bonus;
        this.lottos = lottos;
        setMap();
    }

    public Map<Rank, Integer> getWinningRankResult() {
        return map;
    }

    public void checkWinningRankResult() {
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            checkWinningRank(lotto);
        }
    }

    private void checkWinningRank(Lotto lotto) {
        int rank = checkWinningNumbers(lotto);
        if (rank == Rank.FIRST.getMatchNumberCount()) {
            map.compute(Rank.FIRST, (k, v) -> v + 1);
        }
        if (rank == Rank.SECOND.getMatchNumberCount() && isBonusCheck(lotto)) {
            map.compute(Rank.SECOND, (k, v) -> v + 1);
        }
        if (rank == Rank.THIRD.getMatchNumberCount() && !isBonusCheck(lotto)) {
            map.compute(Rank.THIRD, (k, v) -> v + 1);
        }
        if (rank == Rank.FOURTH.getMatchNumberCount()) {
            map.compute(Rank.FOURTH, (k, v) -> v + 1);
        }
        if (rank == Rank.FIFTH.getMatchNumberCount()) {
            map.compute(Rank.FIFTH, (k, v) -> v + 1);
        }
    }

    private void setMap() {
        map.put(Rank.FIRST, 0);
        map.put(Rank.SECOND, 0);
        map.put(Rank.THIRD, 0);
        map.put(Rank.FOURTH, 0);
        map.put(Rank.FIFTH, 0);
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
