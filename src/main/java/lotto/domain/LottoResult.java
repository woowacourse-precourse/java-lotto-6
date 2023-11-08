package lotto.domain;

import java.util.Map;

// 로또 당첨 결과를 나타내는 클래스
public class LottoResult {
    private final Map<Rank, Integer> result;

    public LottoResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public int getTotalPrize() {
        int totalPrize = 0;

        for (Map.Entry<Rank, Integer> entry : result.entrySet()) {
            totalPrize += entry.getKey().getPrize() * entry.getValue();
        }

        return totalPrize;
    }

    public double calculateReturnRate(int purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0.0;
        }
        return ((double) getTotalPrize() / purchaseAmount) * 100;
    }
}
