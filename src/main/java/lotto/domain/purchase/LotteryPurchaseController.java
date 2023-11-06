package lotto.domain.purchase;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lottos;
import lotto.domain.purchase.issue.LotteryIssueService;
import lotto.domain.purchase.lottocount.LotteryCountService;

public class LotteryPurchaseController {
    private final LotteryCountService lotteryCountService = new LotteryCountService();
    private final LotteryIssueService lotteryIssueService = new LotteryIssueService();

    public Lottos purchase() {
        // 티켓 개수 구하기
        String cashInput = Console.readLine();
        Integer lottoTicketCount = lotteryCountService.getLottoTicketCount(cashInput);

        // 개수만큼 티켓 발행
        return lotteryIssueService.issueLottoAmountOf(lottoTicketCount);
    }
}
