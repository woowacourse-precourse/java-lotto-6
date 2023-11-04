package lotto.dto;

import java.util.List;

public record LottoNumberResponses(
        int purchaseCount,
        List<LottoNumberResponse> lottoResponses
) {
}
