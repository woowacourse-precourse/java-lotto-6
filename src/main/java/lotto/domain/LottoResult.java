package lotto.domain;

import java.util.HashMap;

public class LottoResult {
    private final Map<LottoRank, Integer> result;

    public LottoResult() {
        this.result = new HashMap<>();
    }

    public void add(LottoRank rank) {
    }

    // 수익률 계산 로직 작성 필요
    public double calculateEarningsRate(int purchaseAmount) {

    }
}

