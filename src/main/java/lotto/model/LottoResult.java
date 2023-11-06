package lotto.model;

import java.util.ArrayList;
import java.util.List;

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
