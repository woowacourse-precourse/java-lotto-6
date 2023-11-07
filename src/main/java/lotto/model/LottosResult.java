package lotto.model;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import lotto.model.constans.WinningRank;

public class LottosResult implements Iterable<WinningRank> {
    private final Map<WinningRank, Integer> lottosResult;

    private LottosResult(Map<WinningRank, Integer> lottosResult) {
        this.lottosResult = lottosResult;
    }

    public static LottosResult create() {
        Map<WinningRank, Integer> lottosResult = new LinkedHashMap<>();
        for (WinningRank winningRank : WinningRank.values()) {
            lottosResult.put(winningRank, 0);
        }
        return new LottosResult(lottosResult);
    }

    public void updateResult(WinningRank winningRank) {
        lottosResult.merge(winningRank, 1, Integer::sum);
    }

    public Integer get(WinningRank key) {
        return lottosResult.get(key);
    }

    @Override
    public Iterator<WinningRank> iterator() {
        return lottosResult.keySet().iterator();
    }
}
