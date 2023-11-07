package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lotto.model.constans.WinningPrize;

public class LottosResult {
    private final Map<WinningPrize, Integer> lottosResult;

    private LottosResult(Map<WinningPrize, Integer> lottosResult) {
        this.lottosResult = lottosResult;
    }

    public static LottosResult create() {
        Map<WinningPrize, Integer> lottosResult = new LinkedHashMap<>();
        for(WinningPrize winningPrize : WinningPrize.values()) {
            lottosResult.put(winningPrize, 0);
        }
        return new LottosResult(lottosResult);
    }

    public void updateResult(WinningPrize winningPrize) {
        lottosResult.merge(winningPrize, 1, Integer::sum);
    }

    public Set<Entry<WinningPrize, Integer>> entrySet() {
        return lottosResult.entrySet();
    }

    public Integer get(WinningPrize key) {
        return lottosResult.get(key);
    }
}
