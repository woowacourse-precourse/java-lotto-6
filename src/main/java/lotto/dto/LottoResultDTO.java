package lotto.dto;

import lotto.domain.LottoRankInfo;

import java.util.Map;

public record LottoResultDTO(String returnRatio, Map<LottoRankInfo, Integer> rank) {
}
