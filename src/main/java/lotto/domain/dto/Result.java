package lotto.domain.dto;

import java.math.BigDecimal;
import java.util.EnumMap;
import lotto.domain.Rank;

public record Result(EnumMap<Rank, Integer> rankResult, BigDecimal rateOfReturn) {
}
