package lotto.dto;

import java.math.BigDecimal;
import java.util.Map;
import lotto.domain.Rank;

public record Result(Map<Rank, Integer> rankResult, BigDecimal rateOfReturn) {
}
