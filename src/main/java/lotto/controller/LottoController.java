package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.LottosFactory;
import lotto.domain.WinningNumber;
import lotto.view.ExceptionView;
import lotto.view.InputView;

public class LottoController {

    private final InputView inputView = new InputView();
    private final ExceptionView exceptionView = new ExceptionView();

    public void lottoRun() {
        Lottos lottos = buyLotto();
        WinningNumber winningNumber = decideWinningNumber();
        decideBonusNumber(winningNumber);

    }

    private Lottos buyLotto() {
        LottosFactory lottosFactory = new LottosFactory();
        while (true) {
            try {
                return lottosFactory.createLottos(inputView.inputAmount());
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


}
