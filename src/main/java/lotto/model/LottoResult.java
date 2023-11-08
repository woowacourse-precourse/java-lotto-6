package lotto.model;

import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.constant.Ranking;

public class LottoResult {
    private Map<Ranking, Integer> lottoResult;
    private int totalPrizeMoney;

    public LottoResult() {
        lottoResult = EnumSet.allOf(Ranking.class).stream()
                .collect(Collectors.toMap(Function.identity(), e -> 0, (oldValue, newValue) -> newValue,
                        LinkedHashMap::new));
        totalPrizeMoney = 0;
    }

    public void updateResult(Ranking result) {
        lottoResult.put(result, lottoResult.get(result) + 1);

        totalPrizeMoney += result.getPrizeMoney();
    }

    public Map<Ranking, Integer> getLottoResult() {
        return lottoResult;
    }

    public int getTotalPrizeMoney() {
        return totalPrizeMoney;
    }
}
