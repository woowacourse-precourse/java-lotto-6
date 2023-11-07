package lotto.domain;

import java.util.Map;

// 로또 결과를 나타내는 클래스
public class LottoResult {
    private final Map<Rank, Integer> result;

    public LottoResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public int getTotalPrize() {
        return result.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }
}
