package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.constants.Prize;

public class PrizeChecker {
    public Map<Integer, Integer> recordWinningByRank(
            List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        List<Integer> lottoRank = recordRank(lottos, winningNumber, bonusNumber);
        Map<Integer, Integer> winningByRank = new HashMap<>();
        for (int i = Prize.FIRST.getRank(); i <= Prize.FIFTH.getRank(); i++) {
            winningByRank.put(i, 0);
        }
        for (int rank : lottoRank) {
            if (winningByRank.containsKey(rank)) {
                winningByRank.put(rank, winningByRank.get(rank) + 1);
            }
        }
        return winningByRank;
    }

    private List<Integer> recordRank(List<Lotto> lottos, List<Integer> winningNumber, int bonusNumber) {
        List<Integer> lottoRank = new ArrayList<>();
        Map<Integer, Integer> rankTable = createRankTable();
        for (Lotto lotto : lottos) {
            int countingResult = countSameNumbers(lotto.getNumbers(), winningNumber);
            int rank = rankTable.getOrDefault(countingResult, 0);
            if (countingResult == 5 && lotto.getNumbers().contains(bonusNumber)) {
                rank = 2;
            }
            lottoRank.add(rank);
        }
        return lottoRank;
    }

    private Map<Integer, Integer> createRankTable() {
        Map<Integer, Integer> rankTable = new HashMap<>();
        rankTable.put(3, 5);
        rankTable.put(4, 4);
        rankTable.put(5, 3);
        rankTable.put(6, 1);
        return rankTable;
    }

    // 로또 번호와 당첨 번호 비교 -> 일치 개수 반환
    private int countSameNumbers(List<Integer> lottoNumber, List<Integer> winningNumber) {
        int countingResult = 0;
        for (int number : lottoNumber) {
            if (winningNumber.contains(number)) {
                countingResult++;
            }
        }
        return countingResult;
    }
}
