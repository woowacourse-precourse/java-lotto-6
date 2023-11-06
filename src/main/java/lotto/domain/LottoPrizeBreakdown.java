package lotto.domain;

import java.util.Collections;
import java.util.Map;

public class LottoPrizeBreakdown {

    private Map<LottoRank, Integer> prizeDetails;

    public LottoPrizeBreakdown(Map<LottoRank, Integer> prizeDetails) {
        this.prizeDetails = prizeDetails;
    }

    public Map<LottoRank, Integer> getReport() {
        return Collections.unmodifiableMap(prizeDetails);
    }
}
