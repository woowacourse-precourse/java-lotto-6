package lotto.dto;

import lotto.constant.LottoRank;

import java.util.Map;

public record LottoResultDto(double profitRate, Map<LottoRank, Integer> result) {
}
