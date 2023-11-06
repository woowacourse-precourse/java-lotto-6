package lotto.dto;

import lotto.domain.LottoRankInfo;

import java.util.Map;

public class LottoResultDTO extends DTO.Output {
    private final String returnRatio;
    private final Map<LottoRankInfo, Integer> ranks;

    public LottoResultDTO(String returnRatio, Map<LottoRankInfo, Integer> ranks) {
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
