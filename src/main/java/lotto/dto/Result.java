package lotto.dto;

import java.util.EnumMap;
import lotto.domain.rank.Rank;

public record Result(EnumMap<Rank, Integer> rankResult, double revenue) {

}
