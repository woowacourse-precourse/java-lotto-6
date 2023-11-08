package lotto.controller.lotto;

import lotto.domain.lotto.LottoGroup;
import lotto.domain.lotto.LottoPrice;
import lotto.domain.lotto.LottoPurchaseAmount;
import lotto.domain.lotto.issue.LottoIssue;
import lotto.domain.lotto.lottery.RandomLotteryMachine;
import lotto.view.output.LottoIssueOutputView;

public class LottoIssueController {
    private final LottoIssueOutputView lottoIssueOutputView;

    public LottoIssueController(final LottoIssueOutputView lottoIssueOutputView) {
        this.lottoIssueOutputView = lottoIssueOutputView;
    }

    public LottoGroup issue(final LottoPurchaseAmount lottoPurchaseAmount) {
        final LottoIssue lottoIssue = new LottoIssue(new RandomLotteryMachine());
        final LottoGroup lottoGroup = lottoIssue.issue(lottoPurchaseAmount, LottoPrice.ONE);
        lottoIssueOutputView.printPurchasedLottos(lottoGroup);
        lottoIssueOutputView.printNewLine();
        return lottoGroup;
    }
}
