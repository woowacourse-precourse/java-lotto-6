package lotto;

import lotto.domain.LotteryOperator;
import lotto.domain.LotteryResultsCalculator;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {

        LotteryOperator operator = new LotteryOperator();
        Controller controller = new Controller(new InputInterface(), new OutputInterface(), operator,
                new User(), new LotteryResultsCalculator(operator));
        controller.purchaseLotteries();
        controller.drawWinningLottery();
        controller.calculateEarningRate();

    }
}
