package lotto.model.dto;

import java.util.ArrayList;
import java.util.List;
import lotto.model.domain.LottoRank;

public class LottoResult {
    private final List<LottoRank> lottoRanks;

    public LottoResult() {
        this.lottoRanks = new ArrayList<>();
    }

    public void addResult(LottoRank lottoRank) {
        lottoRanks.add(lottoRank);
    }

    public List<LottoRank> getLottoRanks() {
        return new ArrayList<>(lottoRanks);
    }
}
