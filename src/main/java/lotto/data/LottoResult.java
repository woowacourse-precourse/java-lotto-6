package lotto.data;

import lotto.constant.Rank;

import java.util.Map;

public class LottoResult {
    Map<Rank, Integer> lottoResult;

    public LottoResult(Map<Rank, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public Map<Rank, Integer> get() {
        return lottoResult;
    }


}
