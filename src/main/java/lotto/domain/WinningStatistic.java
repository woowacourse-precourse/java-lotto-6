package lotto.domain;

import java.util.EnumMap;
import lotto.constant.LottoResultRule;

public class WinningStatistic {

    private final EnumMap<LottoResultRule, Integer> elements = new EnumMap<>(LottoResultRule.class);

    public WinningStatistic(EnumMap<LottoResultRule, Integer> input) {
        for (LottoResultRule value : LottoResultRule.values()) {
            this.elements.put(value, input.getOrDefault(value, 0));
        }
    }

    public Integer getTotalPrize() {
        Integer totalPrize = 0;
        for (LottoResultRule rule : elements.keySet()) {
            totalPrize += rule.toPrize() * elements.get(rule);
        }
        return totalPrize;
    }

    public EnumMap<LottoResultRule, Integer> toElements() {
        return elements;
    }
}
