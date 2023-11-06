package lotto.dto;

import lotto.domain.LottoRanking;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultDto {
    private final Map<String, Integer> result;

    public LottoResultDto(Map<LottoRanking, Integer> result) {
        this.result = generateResultFrom(result);
    }

    private Map<String, Integer> generateResultFrom(Map<LottoRanking, Integer> result) {
        return result.keySet()
                .stream()
                .collect(Collectors.toMap(Enum::name, result::get));
    }

    public Map<String, Integer> getResult() {
        return result;
    }
}
