package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private List<Lotto> lottos;
    private Lotto winningNumber;
    private int bonusNumber;
    private final Map<LottoRank, Integer> result;

    public LottoResult(List<Lotto> lottos, Lotto winningNumber, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.result = new HashMap<>();

        for (LottoRank rank : LottoRank.values()) {
            result.put(rank, 0);
        }
        createResult();
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }

    public double getProfitPercentage(int purchasePrice) {
        long totalAmount = getTotalAmount();
        return (double) totalAmount / purchasePrice;
    }

    private void record(LottoRank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    private void createResult() {
        for (Lotto lotto: lottos) {
            LottoRank rank = lotto.checkRank(winningNumber, bonusNumber);
            record(rank);
        }
    }

    private long getTotalAmount() {
        return result.entrySet().stream()
                .mapToLong(entry -> (long) entry.getKey().getWinnings() * entry.getValue())
                .sum();
    }
}
