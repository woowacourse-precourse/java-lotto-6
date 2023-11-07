package lotto;

import java.util.List;

public class LottoController {
    static final int LOTTERY_COST = 1000;

    LotteryService lotteryService = new LotteryService();
    LottoPrinter lottoPrinter = new LottoPrinter();
    LottoInputDevice lottoInputDevice = new LottoInputDevice();

    public void run(){
            int userMoney = lottoInputDevice.getMoney();
            int lotteryCount = userMoney / LOTTERY_COST;

            List<Lotto> totalLottery = lotteryService.getTotalLottery(lotteryCount);
            lottoPrinter.printLotteryList(totalLottery);

            Lotto winningNumber = lottoInputDevice.getWinningNumber();
            int bonusNumber = lottoInputDevice.getBonusNumber(winningNumber);

            List<Ranking> winningInformation = lotteryService.compareLotteryWithWinningNumber(totalLottery, winningNumber, bonusNumber);
            lottoPrinter.printWinningInformation(winningInformation, userMoney);
    }
}
