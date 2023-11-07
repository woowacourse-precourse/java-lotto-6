package lotto.model.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.LottoRank;

public class LottoResult {
    private final List<LottoRank> lottoRanks;
    private final int totalReward;

    public LottoResult(List<LottoRank> lottoRanks, int totalReward) {
        this.lottoRanks = lottoRanks;
        this.totalReward = totalReward;
    }

    public List<LottoRank> getLottoRanks() {
        return new ArrayList<>(lottoRanks);
    }

    public int getTotalReward() {
        return totalReward;
    }
}
