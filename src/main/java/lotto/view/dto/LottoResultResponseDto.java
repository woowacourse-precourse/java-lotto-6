package lotto.view.dto;

import java.util.Map;
import lotto.model.LottoRank;

public record LottoResultResponseDto(Map<LottoRank, Integer> matchResult, double rateOfReturn) {
}
