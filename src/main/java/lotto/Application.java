package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.NumberFormat;
import lotto.domain.LotteryOperator;
import lotto.domain.LotteryResultsCalculator;
import lotto.domain.LotteryRetailer;
import lotto.domain.LottoRandom;
import lotto.domain.User;
import lotto.service.PurchaseLotteryService;

public class Application {
    public static void main(String[] args) {

        LottoRandom random = new LottoRandom();
        LotteryOperator operator = new LotteryOperator();
        LotteryRetailer retailer = new LotteryRetailer(random);
        NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        PurchaseLotteryService purchaseLotteryService = new PurchaseLotteryService(retailer,operator);
        Controller controller = new Controller(new InputInterface(), new OutputInterface(numberFormat),
                operator, new User(), new LotteryResultsCalculator(operator), purchaseLotteryService);
        controller.purchaseLotteries();
        controller.drawWinningLottery();
        controller.calculateEarningRate();
    }
}
