package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.NumberFormat;
import lotto.domain.LotteryOperator;
import lotto.domain.LotteryResultsCalculator;
import lotto.domain.LotteryRetailer;
import lotto.domain.LottoRandom;
import lotto.domain.User;
import lotto.service.ApplyWinningLotteryService;
import lotto.service.PurchaseLotteryService;

public class Application {
    public static void main(String[] args) {

        LottoRandom random = new LottoRandom();
        LotteryOperator operator = new LotteryOperator();
        LotteryRetailer retailer = new LotteryRetailer(random);
        NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        PurchaseLotteryService purchaseLotteryService = new PurchaseLotteryService(retailer,operator);
        ApplyWinningLotteryService applyWinningLotteryService = new ApplyWinningLotteryService(operator);
        Controller controller = new Controller(new InputInterface(), new OutputInterface(numberFormat),
                new User(), new LotteryResultsCalculator(operator), purchaseLotteryService,
                applyWinningLotteryService);
        controller.purchaseLotteries();
        controller.drawWinningLottery();
        controller.calculateEarningRate();
    }
}
