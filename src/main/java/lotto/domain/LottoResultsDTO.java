package lotto.domain;

import java.util.Map;

public record LottoResultsDTO(
        Map<LottoResults, Integer> result,
        long winningAmount,
        int lottoCount
) {
}
