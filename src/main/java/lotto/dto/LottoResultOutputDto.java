package lotto.dto;

import lotto.domain.LottoRankInfo;

import java.util.Map;

public final class LottoResultOutputDto extends OutputDto {
    private final String returnRatio;
    private final Map<LottoRankInfo, Integer> ranks;

    public LottoResultOutputDto(String returnRatio, Map<LottoRankInfo, Integer> ranks) {
        this.returnRatio = returnRatio;
        this.ranks = ranks;
    }

    public String getReturnRatio() {
        return returnRatio;
    }

    public Map<LottoRankInfo, Integer> getRanks() {
        return ranks;
    }
}
