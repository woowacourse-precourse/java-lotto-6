package lotto.model;

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

    public Map<Rank, Integer> calculate() {
        for (Lotto lotto : lottos.getLottos()) {
            resultCalculate(lotto);
        }
        return this.result;
    }

    public String getProfitRate() {
        Money money = new Money(lottos.getLottos().size() * 1000);

        ProfitRateCalculators profitRateCalculators = new ProfitRateCalculators(money, getReward());
        return profitRateCalculators.getProfitRate();
    }

    private BigDecimal getReward() {
        BigDecimal bigDeciaml = BigDecimal.valueOf(0);

        for (Entry<Rank, Integer> entry : result.entrySet()) {
            BigDecimal reward1 = BigDecimal.valueOf(Rank.getReward(entry.getKey()));
            BigDecimal multiply = reward1.multiply(BigDecimal.valueOf(entry.getValue()));
            bigDeciaml = bigDeciaml.add(multiply);
        }
        return bigDeciaml;
    }

    private void resultCalculate(Lotto lotto) {
        Rank rank = getRank(lotto);
        result.put(rank, result.get(rank) + 1);
    }

    private Rank getRank(Lotto lotto) {
        int same = 0;
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            if (winningLottoWithBonus.getLotto().getNumbers().contains(lotto.getNumbers().get(i))) {
                same++;
            }
        }
        if (same == 5) {
            if (lotto.getNumbers().contains(winningLottoWithBonus.getBonus())) {
                return Rank.BONUS;
            }
        }
        return Rank.get(same);
    }


}
