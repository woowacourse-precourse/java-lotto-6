package lotto.dto;

import java.util.Map;
import lotto.constant.LottoRanking;

public record LottoResult(Map<LottoRanking, Integer> winningCounts, Double profitRate) {

}
