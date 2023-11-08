package lotto.domain.ticket;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.order.PurchaseOrder;
import lotto.domain.rank.Rank;

public record LottoTickets(List<Lotto> purchasedLottos, PurchaseOrder purchaseOrder) {

    private static final int ZERO = 0;
    private static final int PERCENTAGE = 100;

    public EnumMap<Rank, Integer> calculateRankResult(final WinningTicket winningTicket) {
        final EnumMap<Rank, Integer> rankResult = initializeRankResult();
        purchasedLottos.stream()
                .map(winningTicket::match)
                .map(Rank::of)
                .filter(rank -> rank != Rank.NONE)
                .forEach(rank -> rankResult.put(rank, rankResult.getOrDefault(rank, ZERO) + 1));
        return rankResult;
    }

    private EnumMap<Rank, Integer> initializeRankResult() {
        final EnumMap<Rank, Integer> rankResult = new EnumMap<>(Rank.class);
        Arrays.stream(Rank.values())
                .forEach(rank -> rankResult.put(rank, ZERO));
        rankResult.remove(Rank.NONE);
        return rankResult;
    }

    public double revenue(final int totalReward) {
        return (double) totalReward / purchaseOrder.amount() * PERCENTAGE;
    }
}
