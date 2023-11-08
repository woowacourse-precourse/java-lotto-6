package lotto.domain;

import java.math.BigDecimal;
import java.util.Map;

public record LottoResult(BigDecimal rateOfReturn, Map<LottoRank, Integer> rankToCount) {
}
