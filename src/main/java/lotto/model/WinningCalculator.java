package lotto.model;

import static lotto.constants.LottoConstants.LOTTO_PRICE;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import lotto.calculators.ProfitRateCalculators;

public class WinningCalculator {

    private final Lottos lottos;
    private final WinningLottoWithBonus winningLottoWithBonus;
    private final Map<Rank, Integer> result = new LinkedHashMap<>();

    public WinningCalculator(Lottos lottos, WinningLottoWithBonus winningLottoWithBonus) {
        init();
        this.lottos = lottos;
        this.winningLottoWithBonus = winningLottoWithBonus;
    }

    private void init() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public Map<Rank, Integer> getResult() {
        for (Lotto lotto : lottos.getLottos()) {
            resultCalculate(lotto);
        }
        return this.result;
    }

    public double getProfitRate() {
        Money money = new Money(lottos.getLottos().size() * LOTTO_PRICE);

        ProfitRateCalculators profitRateCalculators = new ProfitRateCalculators(money,
                getTotalPrize());
        return profitRateCalculators.getProfitRate();
    }

    private BigDecimal getTotalPrize() {
        BigDecimal totalPrize = BigDecimal.ZERO;
        for (Entry<Rank, Integer> entry : result.entrySet()) {
            totalPrize = totalPrize.add(BigDecimal.valueOf(Rank.getReward(entry.getKey()))
                    .multiply(BigDecimal.valueOf(entry.getValue())));
        }
        return totalPrize;
    }

    private void resultCalculate(Lotto lotto) {
        Rank rank = getRank(lotto);
        result.put(rank, result.get(rank) + 1);
    }

    private Rank getRank(Lotto lotto) {
        int rankNum = getRankNum(lotto);
        if (rankNum == 5) {
            return isBonus(lotto, winningLottoWithBonus);
        }
        return Rank.get(rankNum);
    }

    private int getRankNum(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLottoWithBonus.getLotto().getNumbers()::contains).count();
    }

    private Rank isBonus(Lotto lotto, WinningLottoWithBonus winningLottoWithBonus) {
        if (lotto.getNumbers().contains(winningLottoWithBonus.getBonus())) {
            return Rank.BONUS;
        }
        return Rank.FIVE;
    }

}
