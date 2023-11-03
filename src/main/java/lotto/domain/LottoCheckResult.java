package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoCheckResult {
    private final Map<WinningStatus, Integer> result;

    public LottoCheckResult() {
        result = new EnumMap<>(WinningStatus.class);
    }

    public Map<WinningStatus, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public void updateResult(WinningStatus winningStatus) {
        result.put(winningStatus, result.getOrDefault(winningStatus, 0) + 1);
    }
}
