package lotto.domain;

import java.util.Map;

public class LottoResultsDTO {
    private final Map<LottoResults, Integer> result;
    private final int lottoCount;

    public LottoResultsDTO(Map<LottoResults, Integer> result, int lottoCount) {
        this.result = result;
        this.lottoCount = lottoCount;
    }

    public Map<LottoResults, Integer> getResult() {
        return result;
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
