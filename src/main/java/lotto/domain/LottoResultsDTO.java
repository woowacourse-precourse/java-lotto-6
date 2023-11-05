package lotto.domain;

import java.util.Map;

public class LottoResultsDTO {
    private final Map<LottoResults, Integer> result;

    public LottoResultsDTO(Map<LottoResults, Integer> result) {
        this.result = result;
    }

    public Map<LottoResults, Integer> getResult() {
        return result;
    }
}
