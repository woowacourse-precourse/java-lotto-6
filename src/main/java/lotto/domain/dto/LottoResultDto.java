package lotto.domain.dto;

import java.util.HashMap;
import java.util.Map;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public record LottoResultDto(Map<Rank, Integer> result) {

    public static LottoResultDto from(final LottoResult lottoResult) {
        return new LottoResultDto(lottoResult.getResult());
    }

    public Map<Rank, Integer> result() {
        return new HashMap<>(result);
    }
}
