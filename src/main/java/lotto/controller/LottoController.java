package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.domain.WinningResult;
import lotto.domain.factory.LottosFactory;
import lotto.view.ExceptionView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ExceptionView exceptionView = new ExceptionView();

    public void lottoRun() {
        Lottos lottos = buyLotto();
        WinningNumber winningNumber = decideWinningNumber();
        decideBonusNumber(winningNumber);
        WinningResult winningResult = calculateWinning(lottos, winningNumber);
        OutputView.printWinningStatics(winningResult);
        OutputView.printRate(winningResult.calculateRate(lottos));

    }

    private Lottos buyLotto() {
        LottosFactory lottosFactory = new LottosFactory();
        while (true) {
            try {
                Lottos lottos = lottosFactory.createLottos(inputView.inputMoney());
                OutputView.printLottos(lottos);
                return lottos;
            } catch (IllegalArgumentException e) {
                exceptionView.printException(e.getMessage());
            }
        }
    }

    private WinningNumber decideWinningNumber() {
        while (true) {
            try {
                return new WinningNumber(inputView.inputWinningNumber());
            } catch (IllegalArgumentException e) {
                exceptionView.printException(e.getMessage());
            }
        }
    }

    private void decideBonusNumber(WinningNumber winningNumber) {
        while (true) {
            try {
                winningNumber.setBonusNumber(inputView.inputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                exceptionView.printException(e.getMessage());
            }
        }
    }

    private WinningResult calculateWinning(Lottos lottos, WinningNumber winningNumber) {
        WinningResult winningResult = new WinningResult();
        winningResult.calculateWinning(lottos, winningNumber);
        return winningResult;
    }
}
