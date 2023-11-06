package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoBundle {
    private final List<Lotto> lottoBundle;

    public LottoBundle(final List<Lotto> lottoBundle) {
        this.lottoBundle = new ArrayList<>(lottoBundle);
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }

    public Score checkResult(Result result) {
        final Map<LottoRank, Integer> lottoResult = new HashMap<>();
        for (Lotto lotto : this.lottoBundle) {
            LottoRank lottoRank = checkSingleLottoRank(lotto, result);
            lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, 0) + 1);
        }
        return new Score(lottoResult);
    }

    private LottoRank checkSingleLottoRank(Lotto lotto, Result result) {
        final int matchNumberResult = result.matchWinningLotto(lotto);
        final boolean matchBonusBallResult = result.matchBonusBall(lotto);
        return LottoRank.findLottoRank(matchNumberResult, matchBonusBallResult);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoBundle that = (LottoBundle) o;
        return Objects.equals(lottoBundle, that.lottoBundle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoBundle);
    }
}
