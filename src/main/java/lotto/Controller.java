package lotto;

import java.util.List;
import lotto.domain.User;
import lotto.service.ApplyWinningLotteryService;
import lotto.service.CalculateResultService;
import lotto.service.PurchaseLotteryService;
import lotto.service.dto.LotteryResultsDto;
import lotto.service.dto.LotteryReceiptDto;

public class Controller {
    private InputInterface in;
    private OutputInterface out;
    private String username;
    private PurchaseLotteryService purchaseLotteryService;
    private ApplyWinningLotteryService applyWinningLotteryService;
    private CalculateResultService calculateResultService;

    public Controller(InputInterface in, OutputInterface out, String username,
                      PurchaseLotteryService purchaseLotteryService,
                      ApplyWinningLotteryService applyWinningLotteryService,
                      CalculateResultService calculateResultService) {
        this.in = in;
        this.out = out;
        this.username = username;
        this.purchaseLotteryService = purchaseLotteryService;
        this.applyWinningLotteryService = applyWinningLotteryService;
        this.calculateResultService = calculateResultService;
    }

    public void purchaseLotteries() {
        long purchasedAmount = in.getPurchasedAmount();
       LotteryReceiptDto receipt = purchaseLotteryService.purchase(username, purchasedAmount);
        out.printReceipt(receipt);
    }

    public void drawWinningLottery() {
        List<Integer> winningNumbers = in.getWinningNumbers();
        int bonusNumber = in.getBonusNumber(winningNumbers);
        applyWinningLotteryService.apply(winningNumbers, bonusNumber);
    }

    public void calculateEarningRate() {
        LotteryResultsDto result = calculateResultService.calculate(username);
        out.printResults(result.results(), result.earningRate());
    }
}
