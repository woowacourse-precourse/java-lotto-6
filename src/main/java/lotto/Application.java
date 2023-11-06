package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.NumberFormat;
import lotto.domain.LotteryOperator;
import lotto.domain.LotteryResultsCalculator;
import lotto.domain.User;

public class Application {
    public static void main(String[] args) {

        LotteryOperator operator = new LotteryOperator();
        NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        Controller controller = new Controller(new InputInterface(), new OutputInterface(numberFormat),
                operator, new User(), new LotteryResultsCalculator(operator));
        controller.purchaseLotteries();
        controller.drawWinningLottery();
        controller.calculateEarningRate();
//        Console.close();

    }
}
