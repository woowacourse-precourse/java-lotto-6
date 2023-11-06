package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.utils.StringParser;

public class WinningNumberChecker {
    private final List<Integer> winningNumber;
    private final int bonus;
    private final Lottos lottos;
    private Map<String, Integer> map = new HashMap<>();

    public WinningNumberChecker(List<Integer> winningNumber, int bonus, Lottos lottos) {
        this.winningNumber = winningNumber;
        this.bonus = bonus;
        this.lottos = lottos;
        setMap();
    }

    public Map<String, Integer> getWinningRankResult() {
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
        if (rank == 6) {
            map.compute("1st", (k, v) -> v + 1);
        }
        if (rank == 5 && isBonusCheck(lotto)) {
            map.compute("2nd", (k, v) -> v + 1);
        }
        if (rank == 5 && !isBonusCheck(lotto)) {
            map.compute("3rd", (k, v) -> v + 1);
        }
        if (rank == 4) {
            map.compute("4th", (k, v) -> v + 1);
        }
        if (rank == 3) {
            map.compute("5th", (k, v) -> v + 1);
        }
    }

    private void setMap() {
        map.put("1st", 0);
        map.put("2nd", 0);
        map.put("3rd", 0);
        map.put("4th", 0);
        map.put("5th", 0);
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
