package lotto.domain.purchase;

import lotto.domain.Lottos;
import lotto.domain.io.InputView;
import lotto.domain.io.OutputView;
import lotto.domain.purchase.issue.LotteryIssueService;
import lotto.domain.purchase.lottocount.LotteryCountService;

public class LotteryPurchaseController {
    private final LotteryCountService lotteryCountService = new LotteryCountService();
    private final LotteryIssueService lotteryIssueService = new LotteryIssueService();

    public Lottos purchaseLottoTickets() {
        Integer ticketCount = getTicketCount();

        return getLottos(ticketCount);
    }

    private Lottos getLottos(Integer ticketCount) {
        Lottos lottos = lotteryIssueService.issueLottoAmountOf(ticketCount);
        String lottosStatus = lottos.toString();
        OutputView.printLottos(lottosStatus);
        return lottos;
    }

    private Integer getTicketCount() {
        InputView.getCash();
        Integer ticketCount = lotteryCountService.getLottoTicketCount();
        OutputView.printLottoAmount(ticketCount);
        return ticketCount;
    }
}
