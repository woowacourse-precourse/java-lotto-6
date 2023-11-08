package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import lotto.util.LottoConstants;

public class LottoResult {
    private static final String DIVISION_BY_ZERO_ERROR = "총 구입 금액이 0이어서 수익률을 계산할 수 없습니다.";
    private final Map<LottoRank, Integer> ranksCount;

    public LottoResult() {
        this.ranksCount = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            ranksCount.put(rank, 0);
        }
    }

    public void recordRank(LottoRank rank) {
        ranksCount.merge(rank, 1, Integer::sum);
    }

    public int calculateTotalWinningAmount() {
        return ranksCount.entrySet().stream().mapToInt(entry -> entry.getKey().getPrize() * entry.getValue()).sum();
    }

    public double calculateProfitRate(int numberOfTickets) {
        if (numberOfTickets <= 0) {
            throw new IllegalArgumentException(DIVISION_BY_ZERO_ERROR);
        }
        int totalWinningAmount = calculateTotalWinningAmount();

        return (double) totalWinningAmount / (numberOfTickets * LottoConstants.LOTTO_PRICE) * 100;
    }

    public int getCountOfRank(LottoRank rank) {
        return ranksCount.getOrDefault(rank, 0);
    }
}
