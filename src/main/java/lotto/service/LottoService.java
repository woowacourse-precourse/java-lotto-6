package lotto.service;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.order.PurchaseOrder;
import lotto.domain.rank.Rank;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.ticket.WinningTicket;
import lotto.dto.Result;

public class LottoService {

    private final LottoMachine lottoMachine;

    public LottoService() {
        this(new LottoMachine());
    }

    public LottoService(final LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    public LottoTickets purchase(final PurchaseOrder purchaseOrder) {
        final List<Lotto> purchasedLottos = lottoMachine.purchase(purchaseOrder);
        return new LottoTickets(purchasedLottos, purchaseOrder);
    }

    public Result getWinningResult(final LottoTickets lottoTickets, final WinningTicket winningTicket) {
        final EnumMap<Rank, Integer> rankResult = lottoTickets.calculateRankResult(winningTicket);
        final int totalReward = Rank.totalReward(rankResult);
        final double revenue = lottoTickets.revenue(totalReward);
        return new Result(rankResult, revenue);
    }
}
