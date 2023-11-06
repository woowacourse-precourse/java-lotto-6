package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;

public class LottoTickets {
    private final PurchaseAmount purchaseAmount;
    private final List<Lotto> lottos;

    public LottoTickets(List<Lotto> lottoTickets, PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = lottoTickets;
    }

    public EnumMap<Rank, Integer> getRankResult(WinningTicket winningTicket) {
        EnumMap<Rank, Integer> rankResult = initRankResult();

        lottos.stream()
                .map(lotto -> Rank.of(lotto, winningTicket))
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
                .divide(new BigDecimal(purchaseAmount.getAmount()), 1, RoundingMode.HALF_UP);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
