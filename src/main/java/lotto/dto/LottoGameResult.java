package lotto.dto;

import lotto.domain.RankInfo;

import java.util.HashMap;

public record LottoGameResult(HashMap<RankInfo, Integer> gameResult) {
}
