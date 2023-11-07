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
    private final Map<PrizeRank, Integer> result = new LinkedHashMap<>();

    public WinningCalculator(Lottos lottos, WinningLottoWithBonus winningLottoWithBonus) {
        init();
        this.lottos = lottos;
        this.winningLottoWithBonus = winningLottoWithBonus;
    }

    private void init() {
        for (PrizeRank prizeRank : PrizeRank.values()) {
            result.put(prizeRank, 0);
        }
    }

    public Map<PrizeRank, Integer> getResult() {
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
        for (Entry<PrizeRank, Integer> entry : result.entrySet()) {
            totalPrize = totalPrize.add(BigDecimal.valueOf(PrizeRank.getReward(entry.getKey()))
                    .multiply(BigDecimal.valueOf(entry.getValue())));
        }
        return totalPrize;
    }

    private void resultCalculate(Lotto lotto) {
        PrizeRank prizeRank = getRank(lotto);
        result.put(prizeRank, result.get(prizeRank) + 1);
    }

    private PrizeRank getRank(Lotto lotto) {
        int rankNum = getRankNum(lotto);
        if (rankNum == 5) {
            return isBonus(lotto, winningLottoWithBonus);
        }
        return PrizeRank.get(rankNum);
    }

    private int getRankNum(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(number -> winningLottoWithBonus.getLotto().isContain(number)).count();
    }

    private PrizeRank isBonus(Lotto lotto, WinningLottoWithBonus winningLottoWithBonus) {
        if (lotto.isContain(winningLottoWithBonus.getBonus())) {
            return PrizeRank.BONUS;
        }
        return PrizeRank.FIVE;
    }

}
