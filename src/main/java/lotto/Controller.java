package lotto;

import java.util.List;
import lotto.domain.LotteryOperator;
import lotto.domain.LotteryReceipt;
import lotto.domain.LotteryResults;
import lotto.domain.LotteryResultsCalculator;
import lotto.domain.LotteryRetailer;
import lotto.domain.LottoRandom;
import lotto.domain.User;

public class Controller {
    private InputInterface in;
    private OutputInterface out;
    private LotteryOperator operator;
    private LotteryResultsCalculator calculator;
    private User user;

    Controller(InputInterface in, OutputInterface out, LotteryOperator operator, User user,
               LotteryResultsCalculator calculator) {
        this.in = in;
        this.out = out;
        this.operator = operator;
        this.user = user;
        this.calculator = calculator;
    }

    public void purchaseLotteries() {
        long purchasedAmount = in.getPurchasedAmount();
        LotteryRetailer retailer = new LotteryRetailer(new LottoRandom());
        LotteryReceipt receipt = retailer.purchase(operator, purchasedAmount);
        user.takeReceipt(receipt);
        out.printReceipt(receipt);
    }

    public void drawWinningLottery() {
        List<Integer> winningNumbers = in.getWinningNumbers();
        int bonusNumber = in.getBonusNumber(winningNumbers);
        operator.draw(winningNumbers, bonusNumber);
    }

    public void calculateEarningRate() {
        List<LotteryReceipt> receipts = user.getReceipts();
        LotteryResults results = calculator.getTotalResults(receipts);
        long resultAmount = results.getTotalAmount();
        long purchaseAmount = calculatePurchaseAmount(receipts);

        double earningRate = ((double)resultAmount / (double)purchaseAmount) * 100;
        out.printResults(results.toList(), earningRate);
    }

    private long calculatePurchaseAmount(List<LotteryReceipt> receipts) {
        return receipts.stream()
                .mapToLong(LotteryReceipt::getPurchasedAmount)
                .sum();
    }


}
