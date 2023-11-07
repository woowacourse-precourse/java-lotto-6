package lotto.domain.lottoresult;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class LottoCheckResult {
    private final Map<LottoResultStatus, Integer> result;

    public LottoCheckResult() {
        result = new EnumMap<>(LottoResultStatus.class);
        initResult();
    }

    public void updateResult(LottoResultStatus lottoResultStatus) {
        result.put(lottoResultStatus, result.get(lottoResultStatus) + 1);
    }

    private void initResult() {
        for (LottoResultStatus status : LottoResultStatus.values()) {
            result.put(status, 0);
        }
    }

    public Map<LottoResultStatus, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }
}
