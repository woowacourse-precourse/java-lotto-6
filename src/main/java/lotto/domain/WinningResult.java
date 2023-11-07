package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private Map<WinningType, Integer> winningResult;

    private WinningResult() {
        this.winningResult = new EnumMap<>(WinningType.class);
    }

    public static WinningResult of() {
        return new WinningResult();
    }
}
