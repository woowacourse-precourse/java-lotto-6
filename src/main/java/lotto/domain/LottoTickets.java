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
        EnumMap<Rank, Integer> rankToInteger = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankToInteger.put(rank, 0);
        }
        for (Lotto lotto : lottos) {
            Rank rank = Rank.of(lotto, winningTicket);
            rankToInteger.put(rank, rankToInteger.get(rank) + 1);
        }
        rankToInteger.remove(Rank.NONE);
        return rankToInteger;
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
