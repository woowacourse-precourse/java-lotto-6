package lotto.controller;

import lotto.controller.lotto.LottoIssueController;
import lotto.controller.lotto.LottoPurchaseController;
import lotto.controller.prize.PrizeController;
import lotto.controller.prize.PrizeStatisticsController;
import lotto.domain.lotto.LottoGroup;
import lotto.domain.lotto.LottoPurchaseAmount;
import lotto.domain.prize.Prize;
import lotto.view.input.LottoPrizeInputView;
import lotto.view.input.LottoPurchaseInputView;
import lotto.view.input.reader.ConsoleReader;
import lotto.view.output.LottoIssueOutputView;
import lotto.view.output.LottoPrizeOutputView;
import lotto.view.output.LottoPurchaseOutputView;
import lotto.view.output.LottoStatisticsOutputView;
import lotto.view.output.writer.ConsoleWriter;

public class LottoGameController {
    private final LottoPurchaseController lottoPurchaseController;
    private final LottoIssueController lottoIssueController;
    private final PrizeController prizeController;
    private final PrizeStatisticsController prizeStatisticsController;

    public LottoGameController(
            final ConsoleReader consoleReader,
            final ConsoleWriter consoleWriter
    ) {
        this.lottoPurchaseController = new LottoPurchaseController(
                new LottoPurchaseInputView(consoleReader),
                new LottoPurchaseOutputView(consoleWriter)
        );
        this.lottoIssueController = new LottoIssueController(
                new LottoIssueOutputView(consoleWriter)
        );
        this.prizeController = new PrizeController(
                new LottoPrizeInputView(consoleReader),
                new LottoPrizeOutputView(consoleWriter)
        );
        this.prizeStatisticsController = new PrizeStatisticsController(
                new LottoStatisticsOutputView(consoleWriter)
        );
    }

    public void start() {
        final LottoPurchaseAmount purchasingAmount = lottoPurchaseController.purchase();
        final LottoGroup issuedLottoGroup = lottoIssueController.issue(purchasingAmount);
        final Prize prize = prizeController.inputPrize();
        prizeStatisticsController.publish(issuedLottoGroup, prize, purchasingAmount);
    }
}
