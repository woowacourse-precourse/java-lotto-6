package lotto.domain.service;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.RankResult;
import lotto.domain.WinningTicket;
import lotto.dto.Result;

public class LottoService {
    public LottoTickets purchase(PurchaseAmount purchaseAmount) {
        List<Lotto> lottoTickets = new LottoShop().purchase(purchaseAmount);
        return new LottoTickets(lottoTickets, purchaseAmount);
    }

    public Result getWinningResult(LottoTickets lottoTickets, WinningTicket winningTicket) {
        RankResult rankResult = lottoTickets.getRankResult(winningTicket);
        BigDecimal rateOfReturn = lottoTickets.getRateOfReturn(rankResult.getTotalPrize());
        return new Result(rankResult, rateOfReturn);
    }
}
