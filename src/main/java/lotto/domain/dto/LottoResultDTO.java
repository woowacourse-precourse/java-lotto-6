package lotto.domain.dto;

import java.util.Map;
import lotto.domain.LottoRank;

public class LottoResultDTO {
    private final Map<LottoRank, Integer> lottoResult;

    public LottoResultDTO(Map<LottoRank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public Map<LottoRank, Integer> getLottoResult() {
        return lottoResult;
    }
}
