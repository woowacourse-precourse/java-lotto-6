package lotto;

import java.util.List;
import java.util.Objects;
import lotto.domain.User;
import lotto.service.ApplyWinningLotteryService;
import lotto.service.CalculateResultService;
import lotto.service.PurchaseLotteryService;
import lotto.service.dto.LotteryResultsDto;
import lotto.service.dto.LotteryReceiptDto;

public class Controller {
    private final InputInterface in;
    private final OutputInterface out;
    private final String username;
    private final PurchaseLotteryService purchaseLotteryService;
    private final ApplyWinningLotteryService applyWinningLotteryService;
    private final CalculateResultService calculateResultService;

    public Controller(InputInterface in, OutputInterface out, String username,
                      PurchaseLotteryService purchaseLotteryService,
                      ApplyWinningLotteryService applyWinningLotteryService,
                      CalculateResultService calculateResultService) {
        this.in = Objects.requireNonNull(in);
        this.out = Objects.requireNonNull(out);
        this.username = username;
        this.purchaseLotteryService = Objects.requireNonNull(purchaseLotteryService);
        this.applyWinningLotteryService = Objects.requireNonNull(applyWinningLotteryService);
        this.calculateResultService = Objects.requireNonNull(calculateResultService);
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
