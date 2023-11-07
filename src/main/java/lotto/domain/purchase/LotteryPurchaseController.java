package lotto.domain.purchase;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.domain.purchase.issue.LotteryIssueService;
import lotto.domain.purchase.lottocount.LotteryCountService;

public class LotteryPurchaseController {
    private final LotteryCountService lotteryCountService = new LotteryCountService();
    private final LotteryIssueService lotteryIssueService = new LotteryIssueService();

    public User purchaseLottoTickets() {
        Integer cash = lotteryCountService.getCash();
        Integer ticketCount = lotteryCountService.getTicketCount(cash);
        List<Lotto> lottos = lotteryIssueService.getLottos(ticketCount);
        return new User(lottos, cash);
    }
}
