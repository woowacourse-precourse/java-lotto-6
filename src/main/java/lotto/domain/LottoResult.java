package lotto.domain;

import java.util.List;
import lotto.util.enums.LottoRank;

public class LottoResult {
    private final List<LottoRank> ranks;

    public LottoResult(List<LottoRank> ranks) {
        this.ranks = ranks;
    }
}
