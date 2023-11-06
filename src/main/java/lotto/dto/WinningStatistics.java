package lotto.dto;

import java.util.Map;
import lotto.constant.LottoRanking;

public record WinningStatistics(Map<LottoRanking, Integer> lottoResults) {
}
