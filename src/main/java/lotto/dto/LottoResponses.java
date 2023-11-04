package lotto.dto;

import java.util.List;

public record LottoResponses(
        int purchaseCount,
        List<LottoResponse> lottoResponses
) {
}
