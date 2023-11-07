package lotto.dto;

import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class LottoResultDto {
    private final Map<LottoRank, Integer> result;

    private LottoResultDto(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public static LottoResultDto from(LottoResult lottoResult) {
        return new LottoResultDto(lottoResult.getResult());
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }
}
