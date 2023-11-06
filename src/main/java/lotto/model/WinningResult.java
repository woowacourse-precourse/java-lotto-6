package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    Map<WinningRank, Integer> winningResult = new EnumMap<>(WinningRank.class);
    Lotto lotto;
    Bonus bonus;
    PlayerLottos playerLottos;
    int totalRevenue;

    public WinningResult(Lotto lotto, Bonus bonus, PlayerLottos playerLottos) {
        this.lotto = lotto;
        this.bonus = bonus;
        this.playerLottos = playerLottos;
        calculateWinningResult();
        calculateTotalRevenue();
    }

    private void calculateTotalRevenue() {
        totalRevenue = 0;
        for (WinningRank winningRank : winningResult.keySet()) {
            totalRevenue += (winningResult.get(winningRank) * winningRank.getReward());
        }
    }

    private void calculateWinningResult() {
        for (PlayerLotto playerLotto : playerLottos.getPlayerLottos()) {
            WinningRank winningRank = calculateRank(playerLotto);
            if (!winningResult.containsKey(winningRank)) {
                winningResult.put(winningRank, 1);
            } else {
                int rankCount = winningResult.get(winningRank);
                winningResult.put(winningRank, rankCount + 1);
            }
        }
    }

    private WinningRank calculateRank(PlayerLotto playerLotto) {
        int matchCount = playerLotto.countIntersection(lotto, bonus);
        boolean hasBonus = playerLotto.hasBonus(bonus);
        return WinningRank.getWinningRank(matchCount, hasBonus);
    }

    public int getTotalRevenue() {
        return totalRevenue;
    }
}
