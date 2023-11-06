package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lotto.enums.Rank;

public class LottoResult {
    private final Map<Rank, Integer> result;

    private LottoResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public static LottoResult of(WinningNumber winningNumber, BonusNumber bonusNumber, LottoTickets lottoTickets) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            Rank rank = Rank.findRank(winningNumber, bonusNumber, lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return new LottoResult(result);
    }

    public int findMatchCountFor(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public double getRateOfReturn(int purchasePrice) {
        int totalPrize = calculateTotalPrize();
        return (totalPrize / (double) purchasePrice) * 100;
    }

    private int calculateTotalPrize() {
        return result.entrySet().stream()
                .filter(this::isGtZero)
                .mapToInt(this::calculateRankPrize)
                .sum();
    }

    private boolean isGtZero(Map.Entry<Rank, Integer> rankDetail) {
        return rankDetail.getValue() > 0;
    }

    private int calculateRankPrize(Map.Entry<Rank, Integer> rankDetail) {
        Rank rank = rankDetail.getKey();
        int winningCount = rankDetail.getValue();
        return rank.getPrize() * winningCount;
    }
}
