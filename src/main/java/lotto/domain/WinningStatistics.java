package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private Map<WinningRank, Integer> winningStatistics = new EnumMap<>(WinningRank.class);
    private BigDecimal revenueRate = BigDecimal.ZERO;

    private WinningStatistics(Lottos userLottos, WinningLotto winningLotto, Budget budget) {
        setWinningStatistics(userLottos, winningLotto);
        setRevenueRate(budget);
    }

    public static WinningStatistics of(Lottos userLottos, WinningLotto winningLotto, Budget budget) {
        return new WinningStatistics(userLottos, winningLotto, budget);
    }

    private void setWinningStatistics(Lottos userLottos, WinningLotto winningLotto) {
        for (Lotto userLotto : userLottos.getLottos()) {
            WinningRank winningResult = createWinningRank(userLotto.getNumbers(), winningLotto);
            updateWinningStatistics(winningResult);
        }
    }

    private WinningRank createWinningRank(List<Integer> userLottoNumbers, WinningLotto winningLotto) {
        int matchesCount = getEachMatchesCount(userLottoNumbers, winningLotto.getLotto().getNumbers());
        boolean isBonus = getHasBonus(userLottoNumbers, winningLotto.getBonus());
        return WinningRank.from(matchesCount, isBonus);
    }

    private int getEachMatchesCount(List<Integer> userLottoNumbers, List<Integer> winNumbers) {
        return (int) userLottoNumbers.stream()
                .filter(winNumbers::contains).count();
    }

    private void updateWinningStatistics(WinningRank winningRank) {
        winningStatistics.put(winningRank, winningStatistics.getOrDefault(winningRank, 0) + 1);
    }

    private boolean getHasBonus(List<Integer> userLottoNumbers, Bonus bonus) {
        return userLottoNumbers.contains(bonus.getBonus());
    }

    private void setRevenueRate(Budget budget) {
        BigDecimal totalAmounts = getTotalAmounts();
        BigDecimal count = getBudget(budget);
        this.revenueRate = calculateRevenueRate(totalAmounts, count);
    }

    private BigDecimal getTotalAmounts() {
        BigDecimal totalAmounts = BigDecimal.ZERO;
        for (Map.Entry<WinningRank, Integer> winningInfo : winningStatistics.entrySet()) {
            BigDecimal amount = BigDecimal.valueOf(winningInfo.getKey().getPrize() * winningInfo.getValue());
            totalAmounts = totalAmounts.add(amount);
        }
        return totalAmounts;
    }

    private BigDecimal getBudget(Budget budget) {
        return new BigDecimal(budget.getBudget());
    }

    private BigDecimal calculateRevenueRate(BigDecimal totalAmounts, BigDecimal counts) {
        BigDecimal rate = totalAmounts.divide(counts, 3, BigDecimal.ROUND_HALF_EVEN);
        return rate.multiply(new BigDecimal("100"));
    }

    public Map<WinningRank, Integer> getWinningStatistics() {
        return winningStatistics;
    }

    public BigDecimal getRevenueRate() {
        return revenueRate;
    }
}
