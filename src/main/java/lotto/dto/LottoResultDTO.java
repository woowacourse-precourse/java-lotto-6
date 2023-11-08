package lotto.dto;

import java.util.Map;
import lotto.domain.LottoRank;

public class LottoResultDTO {
    private final Map<LottoRank, Integer> lottoResultInfo;

    public LottoResultDTO(Map<LottoRank, Integer> lottoResult) {
        this.lottoResultInfo = lottoResult;
    }

    public Map<LottoRank, Integer> getLottoResultInfo() {
        return lottoResultInfo;
    }


}
