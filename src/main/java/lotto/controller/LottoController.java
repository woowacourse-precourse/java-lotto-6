package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.UserLottos;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    private UserLottos userLottos;

    public void startLotto() {
        buyLotto();

        outputPurchasedLotto();
        outputNewLine();

        inputWinningNumber();

        outputWinningStatistics();
        outputRateOfReturn();
    }

    private void outputRateOfReturn() {
        outputView.outputRateOfReturn(userLottos.calculateRateOfReturn(userLottos.calculateWinnings()));
    }

    private void outputWinningStatistics() {
        outputView.outputWinningStatistics();
        outputView.outputFifthPlace(userLottos.getThreeWins());
        outputView.outputFourthPlace(userLottos.getFourWins());
        outputView.outputThirdPlace(userLottos.getFiveWins());
        outputView.outputSecondPlace(userLottos.getFiveAndBonusWins());
        outputView.outputFirstPlace(userLottos.getSixWins());
    }

    private void inputWinningNumber() {
        WinningLotto winningLotto = new WinningLotto(inputView.inputWinningNumber());
        winningLotto.addBonusNumber(inputView.inputBonusNumber());
    }

    private void outputNewLine() {
        outputView.outputNewLine();
    }

    private void outputPurchasedLotto() {
        outputNumberOfPurchases();
        outputLotto();
    }

    private void buyLotto() {
        userLottos = new UserLottos(inputLottoAmount());
    }

    private void outputNumberOfPurchases() {
        outputView.outputNumberOfPurchases(userLottos.getLottoNumbers());
    }

    private void outputLotto() {
        for (int i = 0; i < userLottos.getLottoNumbers(); i++) {
            Lotto lotto = userLottos.getLotto(i);
            outputView.outputLotto(lotto);
        }
    }

    private int inputLottoAmount() {
        return Integer.parseInt(inputView.inputLottoAmount());
    }
}
