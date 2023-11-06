package lotto.domain;

import java.util.List;

public class LottoResults {

    private final List<LottoResult> lottoResults;

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public List<LottoResult> getLottoResults() {
        return lottoResults;
    }
}
