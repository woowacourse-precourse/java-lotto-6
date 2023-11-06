package lotto.controller;

import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import lotto.util.NumbersGenerator;
import lotto.view.ExceptionView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final ExceptionView exceptionView;
    private final OutputView outputView;
    private final NumbersGenerator numbersGenerator;

    public LottoController(InputView inputView, ExceptionView exceptionView,
                           OutputView outputView, NumbersGenerator numbersGenerator) {
        this.inputView = inputView;
        this.exceptionView = exceptionView;
        this.outputView = outputView;
        this.numbersGenerator = numbersGenerator;
    }

    public void lottoRun() {
        Lottos lottos = buyLotto();
        WinningNumbers winningNumbers = decideWinningNumbers();
        decideBonusNumber(winningNumbers);
        WinningResult winningResult = new WinningResult();
        winningResult.calculateWinning(lottos, winningNumbers);
        outputView.printWinningStatics(winningResult);
        outputView.printEarningRate(winningResult.calculateEarningRate(lottos));

    }

    private Lottos buyLotto() {
        while (true) {
            try {
                Lottos lottos = new Lottos(inputView.inputMoney(), numbersGenerator);
                outputView.printLottos(lottos);
                return lottos;
            } catch (IllegalArgumentException e) {
                exceptionView.printException(e.getMessage());
            }
        }
    }

    private WinningNumbers decideWinningNumbers() {
        while (true) {
            try {
                return new WinningNumbers(inputView.inputWinningNumber());
            } catch (IllegalArgumentException e) {
                exceptionView.printException(e.getMessage());
            }
        }
    }

    private void decideBonusNumber(WinningNumbers winningNumbers) {
        while (true) {
            try {
                winningNumbers.setBonusNumber(inputView.inputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                exceptionView.printException(e.getMessage());
            }
        }
    }
}
