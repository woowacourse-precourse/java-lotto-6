package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.text.NumberFormat;
import java.util.Arrays;
import lotto.domain.LotteryOperator;
import lotto.domain.LotteryResultsCalculator;
import lotto.domain.LotteryRetailer;
import lotto.domain.LotteryRound;
import lotto.domain.LottoRandom;
import lotto.service.ApplyWinningLotteryService;
import lotto.service.CalculateResultService;
import lotto.service.PurchaseLotteryService;
import lotto.service.UserService;

public class Application {
    public static void main(String[] args) {

        String username = "user0";
        LottoRandom random = new MissionLottoRandom();
        LotteryOperator operator = new LotteryOperator(new LotteryRound(1), Arrays.asList(CustomLotteryRanking.values()));
        LotteryRetailer retailer = new LotteryRetailer(random);
        UserService userService = new UserService();
        userService.register(username);
        PurchaseLotteryService purchaseLotteryService = new PurchaseLotteryService(retailer, operator, userService);
        ApplyWinningLotteryService applyWinningLotteryService = new ApplyWinningLotteryService(operator);
        CalculateResultService calculateResultService = new CalculateResultService(
                new LotteryResultsCalculator(operator), userService);

        InputValidator validator = new InputValidator();
        InputConverter converter = new InputConverter(validator);
        InputInterface in = new InputInterface(Console::readLine, System.out::println, converter);
        NumberFormat numberFormat = NumberFormat.getIntegerInstance();
        ReceiptRenderer receiptRenderer = new ReceiptRenderer();
        LotteryResultRenderer lotteryResultRenderer = new LotteryResultRenderer(numberFormat);
        OutputInterface out = new OutputInterface(System.out::println, receiptRenderer,
                lotteryResultRenderer);

        Controller controller = new Controller(in, out, username, purchaseLotteryService,
                applyWinningLotteryService, calculateResultService);

        controller.purchaseLotteries();
        controller.drawWinningLottery();
        controller.calculateEarningRate();
    }
}
