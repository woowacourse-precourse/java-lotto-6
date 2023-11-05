package lotto;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {
    private Map<WinningCriteria, Integer> result = new EnumMap<>(WinningCriteria.class);

    public LottoResult() {
        for (WinningCriteria criteria : WinningCriteria.values()) {
            result.put(criteria, 0);
        }
    }

    public void addWin(WinningCriteria criteria) {
        result.merge(criteria, 1, Integer::sum);
    }

    public int getCount(WinningCriteria criteria) {
        return result.get(criteria);
    }
}
