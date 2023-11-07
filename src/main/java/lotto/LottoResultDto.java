package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResultDto {
    private final Map<Rank, Integer> result;

    public LottoResultDto(final Map<Rank, Integer> result) {
        this.result = result;
    }

    public static LottoResultDto from(final LottoResult lottoResult) {
        return new LottoResultDto(lottoResult.getResult());
    }

    public Map<Rank, Integer> getResult() {
        return new HashMap<>(result);
    }
}
