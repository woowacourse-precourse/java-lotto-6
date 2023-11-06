package lotto.dto;

import lotto.domain.LottoRanking;

import java.util.Map;

public record LottoResultDto(Map<LottoRanking, Integer> result) {
}
