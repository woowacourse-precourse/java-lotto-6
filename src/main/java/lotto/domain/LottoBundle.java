package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoBundle {
    private static final int INITIAL_SCORE = 0;
    private static final int INCREASE_SCORE = 1;
    private final List<Lotto> lottoBundle;

    public LottoBundle(final List<Lotto> lottoBundle) {
        this.lottoBundle = new ArrayList<>(lottoBundle);
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }

    public Score checkResult(final Customer customer) {
        final Map<LottoRank, Integer> lottoResult = new HashMap<>();
        for (Lotto lotto : this.lottoBundle) {
            LottoRank lottoRank = checkSingleLottoRank(lotto, customer);
            lottoResult.put(lottoRank, lottoResult.getOrDefault(lottoRank, INITIAL_SCORE) + INCREASE_SCORE);
        }
        return new Score(lottoResult);
    }

    private LottoRank checkSingleLottoRank(final Lotto lotto, final Customer customer) {
        final int matchNumberResult = customer.matchWinningLotto(lotto);
        final boolean matchBonusBallResult = customer.matchBonusBall(lotto);
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
