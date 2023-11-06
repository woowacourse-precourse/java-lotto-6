package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import lotto.enums.Rank;

public class LottoResult {
    private final Map<Rank, Integer> result;

    private LottoResult(Map<Rank, Integer> result) {
        this.result = result;
    }

    public static LottoResult of(WinningNumber winningNumber, BonusNumber bonusNumber, LottoTicket lottoTickets) {
        Map<Rank, Integer> result = new HashMap<>();
        for (Lotto lotto : lottoTickets.getLottoTicket()) {
            Rank rank = Rank.findRank(winningNumber, bonusNumber, lotto);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return new LottoResult(result);
    }

    public int findMatchCountFor(Rank rank) {
        return result.getOrDefault(rank, 0);
    }

    public int calculateTotalPrize() {
        return result.entrySet().stream()
                .filter(this::isGtZero)
                .mapToInt(this::calculateRankPrize)
                .sum();
    }

    private boolean isGtZero(Map.Entry<Rank, Integer> resultDetail) {
        return resultDetail.getValue() > 0;
    }

    private int calculateRankPrize(Map.Entry<Rank, Integer> resultDetail) {
        Rank rank = resultDetail.getKey();
        int winningCount = resultDetail.getValue();
        return rank.getPrize() * winningCount;
    }
}
