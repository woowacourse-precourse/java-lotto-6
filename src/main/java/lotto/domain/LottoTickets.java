package lotto.domain;

import java.math.BigDecimal;
import java.util.List;

public record LottoTickets(List<Lotto> lottos, PurchaseAmount purchaseAmount) {

    public RankResult getRankResult(WinningTicket winningTicket) {
        RankResult rankResult = new RankResult();

        lottos.stream()
                .map(winningTicket::match)
                .map(Rank::of)
                .forEach(rankResult::add);

        return rankResult;
    }

    public BigDecimal getRateOfReturn(long totalPrize) {
        return purchaseAmount.getRateOfReturn(totalPrize);
    }
}
