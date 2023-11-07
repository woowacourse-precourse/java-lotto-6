package lotto.domain.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningTicket;
import lotto.dto.Result;

public class LottoService {
    public LottoTickets purchase(PurchaseAmount purchaseAmount) {
        List<Lotto> lottoTickets = new LottoShop().purchase(purchaseAmount);
        return new LottoTickets(lottoTickets, purchaseAmount);
    }

    public Result getWinningResult(LottoTickets lottoTickets, WinningTicket winningTicket) {
        Map<Rank, Integer> rankResult = lottoTickets.getRankResult(winningTicket);
        long totalPrize = Rank.getTotalPrize(rankResult);
        BigDecimal rateOfReturn = lottoTickets.getRateOfReturn(totalPrize);
        return new Result(rankResult, rateOfReturn);
    }
}
