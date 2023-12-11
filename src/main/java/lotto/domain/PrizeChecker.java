package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.Prize;

public class PrizeChecker {
    private static final int NO_COUNT = 0;
    private static final int COUNT = 1;

    public Map<Integer, Integer> recordWinningByRank(
            List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        Map<Integer, Integer> winningByRank = createWinningByRankMap();
        List<Integer> lottoRank = recordRank(lottos, winningNumber, bonusNumber);
        for (int rank : lottoRank) {
            if (winningByRank.containsKey(rank)) {
                winningByRank.put(rank, winningByRank.get(rank) + COUNT);
            }
        }
        return winningByRank;
    }

    private Map<Integer, Integer> createWinningByRankMap() {
        Map<Integer, Integer> winningByRank = new LinkedHashMap<>();
        for (int i = Prize.FIRST.getRank(); i <= Prize.FIFTH.getRank(); i++) {
            winningByRank.put(i, NO_COUNT);
        }
        return winningByRank;
    }

    private List<Integer> recordRank(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        List<Integer> lottoRank = new ArrayList<>();
        Map<Integer, Integer> rankTable = createRankTable();
        for (Lotto lotto : lottos) {
            int countingResult = countSameNumbers(lotto.getNumbers(), winningNumber);
            int rank = judgeRank(lotto, countingResult, rankTable, bonusNumber);
            lottoRank.add(rank);
        }
        return lottoRank;
    }

    private Map<Integer, Integer> createRankTable() {
        Map<Integer, Integer> rankTable = new HashMap<>();
        rankTable.put(Prize.FIFTH.getMatchingBalls(), Prize.FIFTH.getRank());
        rankTable.put(Prize.FOURTH.getMatchingBalls(), Prize.FOURTH.getRank());
        rankTable.put(Prize.THIRD.getMatchingBalls(), Prize.THIRD.getRank());
        rankTable.put(Prize.FIRST.getMatchingBalls(), Prize.FIRST.getRank());
        return rankTable;
    }

    private int countSameNumbers(List<Integer> lottoNumber, List<Integer> winningNumber) {
        int countingResult = NO_COUNT;
        for (int number : lottoNumber) {
            if (winningNumber.contains(number)) {
                countingResult++;
            }
        }
        return countingResult;
    }

    private int judgeRank(Lotto lotto, int countingResult, Map<Integer, Integer> rankTable, int bonusNumber) {
        int rank = rankTable.getOrDefault(countingResult, NO_COUNT);
        if (countingResult == Prize.THIRD.getMatchingBalls() && lotto.getNumbers().contains(bonusNumber)) {
            rank = Prize.SECOND.getRank();
        }
        return rank;
    }
}
