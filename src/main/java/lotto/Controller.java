package lotto;

import static lotto.resource.TextResourceProvider.OUTPUT_LOTTERY_RESULT;

import java.util.List;
import lotto.domain.LotteryReceipt;
import lotto.domain.LotteryResultsCalculator;
import lotto.domain.LotteryRetailer;
import lotto.domain.LotteryOperator;
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
        long purchaseAmount = calculatePurchaseAmount(receipts);
        long resultAmount = calculateResultAmount(receipts);
        double earningRate = resultAmount / purchaseAmount * 100;
        System.out.println(OUTPUT_LOTTERY_RESULT);
    }

    private long calculatePurchaseAmount(List<LotteryReceipt> receipts) {
        return receipts.stream()
                .mapToLong(LotteryReceipt::getPurchasedAmount)
                .sum();
    }

    private long calculateResultAmount(List<LotteryReceipt> receipts) {
        return receipts.stream()
                .mapToLong(calculator::calculate)
                .sum();
    }

}
