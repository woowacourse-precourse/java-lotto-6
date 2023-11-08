package lotto.controller;

import lotto.constants.GameRule;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.User;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {
    public void start() {
        OutputView.printPayInputMessage();
        User user = InputView.readPayment();
        int lottoCnt = user.getLottoCnt();

        Lottos lottos = Lottos.numberOf(lottoCnt);
        printLottos(lottos, lottoCnt);

        OutputView.printWinningNumberMessage();
        WinningNumber winningNumber = InputView.readWinningNumber();
        OutputView.printBonusNumberMessage();
        BonusNumber bonusNumber = InputView.readBonusNumber(winningNumber);

        Prize prize = new Prize();
        prize.countPrize(lottos, winningNumber, bonusNumber);
        printResult(lottoCnt* GameRule.PAY_UNIT, prize);
    }

    private void printLottos(Lottos lottos, int lottoCnt) {
        OutputView.printPayOutputMessage(lottoCnt);
        for (int i = 0; i < lottoCnt; ++i) {
            Lotto lotto = lottos.getLotto(i);
            OutputView.printNumbers(lotto.getNumbers());
        }
    }

    private void printResult(int pay, Prize prize) {
        String result = prize.getStatisticMessage();
        OutputView.printStatisticsMessage(result);

        double profit = prize.getProfit(pay);
        OutputView.printProfitMessage(profit);
    }
}
