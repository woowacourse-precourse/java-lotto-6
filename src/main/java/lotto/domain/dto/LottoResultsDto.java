package lotto.domain.dto;

import java.util.Collections;
import java.util.Map;
import lotto.domain.lottoresult.LottoResult;

public class LottoResultsDto {
    private final Map<LottoResult, Integer> lottoResultsData;

    public LottoResultsDto(Map<LottoResult, Integer> lottoResultsData) {
        this.lottoResultsData = lottoResultsData;
    }

    public Map<LottoResult, Integer> getLottoResultsData() {
        return Collections.unmodifiableMap(lottoResultsData);
    }
}
