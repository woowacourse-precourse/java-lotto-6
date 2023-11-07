package lotto.domain.service;

import java.math.BigDecimal;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.LottoTickets;
import lotto.domain.PurchaseAmount;
import lotto.domain.RankResult;
import lotto.domain.WinningTicket;
import lotto.dto.WinningResult;

public class LottoService {
    private final LottoShop lottoShop;

    public LottoService(LottoShop lottoShop) {
        this.lottoShop = lottoShop;
    }

    public LottoTickets purchase(PurchaseAmount purchaseAmount) {
        List<Lotto> lottoTickets = lottoShop.purchase(purchaseAmount);
        return new LottoTickets(lottoTickets, purchaseAmount);
    }

    public WinningResult getWinningResult(LottoTickets lottoTickets, WinningTicket winningTicket) {
        RankResult rankResult = lottoTickets.getRankResult(winningTicket);
        BigDecimal rateOfReturn = lottoTickets.getRateOfReturn(rankResult.getTotalPrize());
        return new WinningResult(rankResult, rateOfReturn);
    }
}
