package lotto.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import lotto.model.constans.WinningRank;

public class LottosResult {
    private final Map<WinningRank, Integer> lottosResult;

    private LottosResult(Map<WinningRank, Integer> lottosResult) {
        this.lottosResult = lottosResult;
    }

    public static LottosResult create() {
        Map<WinningRank, Integer> lottosResult = new LinkedHashMap<>();
        for(WinningRank winningRank : WinningRank.values()) {
            lottosResult.put(winningRank, 0);
        }
        return new LottosResult(lottosResult);
    }

    public void updateResult(WinningRank winningRank) {
        lottosResult.merge(winningRank, 1, Integer::sum);
    }

    public Set<Entry<WinningRank, Integer>> entrySet() {
        return lottosResult.entrySet();
    }

    public Integer get(WinningRank key) {
        return lottosResult.get(key);
    }
}
