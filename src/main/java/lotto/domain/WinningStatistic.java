package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import lotto.constant.LottoResultRule;

public class WinningStatistic {

    private final EnumMap<LottoResultRule, Integer> elements = new EnumMap<>(LottoResultRule.class);

    public WinningStatistic(Map<LottoResultRule, Integer> input) {
        for (LottoResultRule value : LottoResultRule.values()) {
            this.elements.put(value, input.getOrDefault(value, 0));
        }
    }

    public Integer getTotalPrize() {
        return elements.entrySet().stream()
                .map(entry -> entry.getKey().toPrize() * entry.getValue())
                .reduce(0, Integer::sum);
    }

    public Map<LottoResultRule, Integer> toElements() {
        return elements;
    }
}
