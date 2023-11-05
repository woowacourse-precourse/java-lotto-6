package lotto.winningmanager;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import lotto.lotto.Lotto;
import lotto.lotto.WinningLotto;

public enum WinningManager {
    WINNING_MANAGER(Arrays.asList(null, WinningRank.RANK_1ST, WinningRank.RANK_2ND, WinningRank.RANK_3RD,
            WinningRank.RANK_4TH, WinningRank.RANK_5TH));

    private final List<WinningRank> winningRanks;
    private final Map<Integer, Integer> winningMap;

    private WinningManager(List<WinningRank> winningRanks) {
        this.winningRanks = winningRanks;
        winningMap = new HashMap<>(6);
        makeMap();
    }

    private void makeMap() {
        winningMap.put(6, 1);
        winningMap.put(5, 2);
        winningMap.put(4, 4);
        winningMap.put(3, 5);
    }

    public String getRankMessage(int rank) {
        return winningRanks.get(rank).getMessage();
    }

    public long getTotalPrice(List<Integer> lottoRanks) {
        long totalPrice = 0;
        for(int i = 1; i <= 5; ++i)
            totalPrice += winningRanks.get(i).getPrice() * lottoRanks.get(i);
        return totalPrice;
    }

    public int getWinningRank(WinningLotto winningLotto, Lotto purchasedLotto) {
        long sameCount = purchasedLotto.getNumbers().stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();

        return findRank((int) sameCount, purchasedLotto.getNumbers().contains(winningLotto.getBonusNumber()));
    }

    private int findRank(int sameCount, boolean isSameBonus) {
        if (sameCount < 3) {
            return 0;
        }
        if (sameCount == 5 && isSameBonus) {
            return winningMap.get((int) sameCount) + 1;
        }
        return winningMap.get((int) sameCount);
    }

}
