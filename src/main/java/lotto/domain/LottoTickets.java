package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;

public record LottoTickets(List<Lotto> lottos, PurchaseAmount purchaseAmount) {

    public EnumMap<Rank, Integer> getRankResult(WinningTicket winningTicket) {
        EnumMap<Rank, Integer> rankResult = initRankResult();

        lottos.stream()
                .map(winningTicket::match)
                .map(Rank::of)
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> rankResult.put(rank, rankResult.get(rank) + 1));

        return rankResult;
    }

    private EnumMap<Rank, Integer> initRankResult() {
        EnumMap<Rank, Integer> rankResult = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankResult.put(rank, 0);
        }
        rankResult.remove(Rank.NONE);
        return rankResult;
    }

    public BigDecimal getRateOfReturn(long totalPrize) {
        return new BigDecimal(totalPrize)
                .multiply(new BigDecimal("100"))
                .divide(new BigDecimal(purchaseAmount.amount()), 1, RoundingMode.HALF_UP);
    }
}
