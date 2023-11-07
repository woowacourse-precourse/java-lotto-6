package lotto;

import java.util.List;
import lotto.domain.User;
import lotto.service.ApplyWinningLotteryService;
import lotto.service.CalculateResultService;
import lotto.service.PurchaseLotteryService;
import lotto.service.dto.CalculationOutcome;
import lotto.service.dto.LotteryReceiptDto;

public class Controller {
    private InputInterface in;
    private OutputInterface out;
    private User user;
    private PurchaseLotteryService purchaseLotteryService;
    private ApplyWinningLotteryService applyWinningLotteryService;
    private CalculateResultService calculateResultService;

    Controller(InputInterface in, OutputInterface out, User user,
               PurchaseLotteryService purchaseLotteryService,
               ApplyWinningLotteryService applyWinningLotteryService, CalculateResultService calculateResultService) {
        this.in = in;
        this.out = out;
        this.user = user;
        this.purchaseLotteryService = purchaseLotteryService;
        this.applyWinningLotteryService = applyWinningLotteryService;
        this.calculateResultService = calculateResultService;
    }

    public void purchaseLotteries() {
        long purchasedAmount = in.getPurchasedAmount();
       LotteryReceiptDto receipt = purchaseLotteryService.purchase(user, purchasedAmount);
        out.printReceipt(receipt);
    }

    public void drawWinningLottery() {
        List<Integer> winningNumbers = in.getWinningNumbers();
        int bonusNumber = in.getBonusNumber(winningNumbers);
        applyWinningLotteryService.apply(winningNumbers, bonusNumber);
    }

    public void calculateEarningRate() {
        CalculationOutcome outcome = calculateResultService.calculate(user);
        out.printResults(outcome.results(), outcome.earningRate());
    }
}
