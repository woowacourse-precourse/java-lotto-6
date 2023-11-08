package lotto.domain;

import java.util.Map;
import lotto.enums.WinningRankType;

public class WinningResult {
    private final Map<WinningRankType, Integer> result;

    public WinningResult(Map<WinningRankType, Integer> result) {
        this.result = result;
    }

    public Map<WinningRankType, Integer> getResult() {
        return result;
    }
}
