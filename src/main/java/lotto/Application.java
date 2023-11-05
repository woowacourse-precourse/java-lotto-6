package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Ranks;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String purchasePrice = InputView.purchasePrice();
        LottoController lottoController = new LottoController();
        List<Lotto> lottery = lottoController.buyLottery(purchasePrice);
        OutputView.printLotteryNumber(lottery);

        String winningNumber = InputView.winningNumber();
        LottoNumber bonusNumber = new LottoNumber(InputView.bonusNumber());
        Ranks ranks = lottoController.lottoResults(lottery, winningNumber, bonusNumber);

        OutputView.printLotteryResult(ranks.lotteryRankStatus());
        OutputView.printRateOfReturn(ranks.calWinningPrice(), purchasePrice);
    }
}
