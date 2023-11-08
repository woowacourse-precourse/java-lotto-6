package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private Map<WinningRank, Integer> rankCounts;
    private long totalReward;

    public LottoResult() {
        rankCounts = new HashMap<>();

        for (WinningRank rank : WinningRank.values()) {
            rankCounts.put(rank, 0);
        }
    }

    //총 결과 메서드
    public void makeResult(List<Lotto> lottoTickets, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottoTickets) {
            WinningRank rank = checkLotto(lotto, winningNumbers);
            updateRankCount(rank);
            updateTotalReward(rank);
        }
    }

    //로또 한장 결과 확인
    public WinningRank checkLotto(Lotto lotto, WinningNumbers winningNumbers) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> comparingNumbers = winningNumbers.getWinningNumbers();

        int matchedCount = (int) numbers.stream().filter(comparingNumbers::contains).count();
        boolean bonusMatched = numbers.contains(winningNumbers.getBonusNumber());

        return WinningRank.valueOf(matchedCount, bonusMatched);
    }

    public void updateRankCount(WinningRank rank) {
        int count = rankCounts.get(rank);
        rankCounts.put(rank, count + 1);
    }

    public void updateTotalReward(WinningRank rank) {
        totalReward += rank.getPrize();
    }

    public int getCountByRank(WinningRank rank) {
        return rankCounts.get(rank);
    }

    public long getTotalReward() {
        return totalReward;
    }

    public Map<WinningRank, Integer> getRankCounts() {
        return rankCounts;
    }
}
