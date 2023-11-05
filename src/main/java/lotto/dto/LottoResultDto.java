package lotto.dto;

import lotto.domain.LottoRanking;

import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResultDto {
    private final Map<String, Integer> result = new LinkedHashMap<>();

    public LottoResultDto(Map<LottoRanking, Integer> result) {
        result.forEach((key, value) -> this.result.put(key.name(), value));
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
