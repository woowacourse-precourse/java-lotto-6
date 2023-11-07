package lotto.dto;

import java.util.Map;
import lotto.model.LottoRank;

public class LottosCalculateResult {
    private final Map<LottoRank, Integer> matches; // 로또 당첨 결과
    private final double rateOfReturn; // 수익률

    public LottosCalculateResult(Map<LottoRank, Integer> matches, double rateOfReturn) {
        this.matches = matches;
        this.rateOfReturn = rateOfReturn;
    }

    public Map<LottoRank, Integer> getMatches() {
        return matches;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
