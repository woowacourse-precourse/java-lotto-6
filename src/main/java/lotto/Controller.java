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

    Controller(InputInterface in, OutputInterface out, LotteryOperator operator, User user, LotteryResultsCalculator calculator) {
        this.in = in;
        this.out = out;
        this.operator = operator;
        this.user = user;
        this.calculator = calculator;
    }

    void purchaseLotteries() {
        long purchasedAmount = in.getPurchasedAmount();
        LotteryRetailer retailer = new LotteryRetailer(new LottoRandom());
        LotteryReceipt receipt = retailer.purchase(operator, purchasedAmount);
        user.takeReceipt(receipt);
        out.printReceipt(receipt);
    }

    void drawWinningLottery() {
        List<Integer> winningNumbers = in.getWinningNumbers();
        int bonusNumber = in.getBonusNumber(winningNumbers);
        operator.draw(winningNumbers, bonusNumber);
    }

    void calculateEarningRate() {
        List<LotteryReceipt> receipts = user.getReceipts();
        long result = 0;
        for (LotteryReceipt receipt : receipts){
            result += calculator.calculate(receipt);
        }
        System.out.println(OUTPUT_LOTTERY_RESULT);
    }
}
