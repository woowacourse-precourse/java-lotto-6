package lotto.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoCheckResult {
    private final Map<WinningStatus, Integer> result;

    public LottoCheckResult() {
        result = new EnumMap<>(WinningStatus.class);
        initResult();
    }

    public Map<WinningStatus, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public void updateResult(WinningStatus winningStatus) {
        result.put(winningStatus, result.get(winningStatus) + 1);
    }

    private void initResult() {
        for (WinningStatus status : WinningStatus.values()) {
            result.put(status, 0);
        }
    }
}
