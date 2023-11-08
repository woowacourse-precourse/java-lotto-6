package lotto.controller;

import static lotto.util.OutputEnum.WINNING_RESULT_OUTPUT;

import lotto.domain.Amount;
import lotto.domain.Calculator;
import lotto.domain.LottoPublisher;
import lotto.domain.WinningResult;
import lotto.domain.lotto.Bonus;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class GameManager {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoPublisher lottoPublisher = new LottoPublisher();
    private Calculator calculator = new Calculator();

    public void run() {
        Amount amount = inputView.inputPurchaseAmount();
        outputView.printPublishedLottoCount(lottoPublisher.getLottoCountByAmount(amount));
        Lottos lottos = lottoPublisher.publishLottosByAmount(amount);
        outputView.printPublishedLottos(lottos);
        Lotto winningLotto = inputView.inputWinningNumbers();
        Bonus bonus = inputView.inputBonusNumber();
        WinningResult winningResult = new WinningResult(lottos.determineWinningsCount(winningLotto,bonus));
        outputView.printWinningResult(winningResult);
        long prize = winningResult.getTotalLotteryPrize();
        outputView.printROI(calculator.calculateROI(prize,amount));
    }

}
