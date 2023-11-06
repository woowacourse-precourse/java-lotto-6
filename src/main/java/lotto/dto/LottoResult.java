package lotto.dto;

import java.util.List;
import lotto.constant.Rank;

public record LottoResult(List<Rank> matchedCounts, double roi) {

}
