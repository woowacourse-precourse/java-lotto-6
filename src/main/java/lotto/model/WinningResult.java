package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    Map<WinningRank, Integer> winningResult = new EnumMap<>(WinningRank.class);
    Lotto lotto;
    Bonus bonus;
    PlayerLottos playerLottos;
    double totalRevenue;

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
            totalRevenue += ((double)winningResult.get(winningRank) * winningRank.getReward());
        }
    }

    private void calculateWinningResult() {
        for (PlayerLotto playerLotto : playerLottos.getPlayerLottos()) {
            WinningRank winningRank = calculateRank(playerLotto);
            winningResult.put(winningRank, winningResult.getOrDefault(winningRank,0) + 1);
        }
    }

    private WinningRank calculateRank(PlayerLotto playerLotto) {
        int matchCount = playerLotto.countIntersection(lotto);
        boolean hasBonus = playerLotto.hasBonus(bonus);
        return WinningRank.getWinningRank(matchCount, hasBonus);
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    public Map<WinningRank, Integer> getWinningResult() {
        return winningResult;
    }
}
