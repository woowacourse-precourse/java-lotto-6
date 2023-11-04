package lotto.controller;

import lotto.domain.BonusNumber;
import lotto.domain.Lottos;
import lotto.domain.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void startProgram() {
        purchaseLottos();
        setWinningNumber();
    }

    private void purchaseLottos() {
        Lottos lottos = initLottos();
        printAllLottoNumbers(lottos);
    }

    private Lottos initLottos() {
        return new Lottos(inputView.inputPurchaseAmount());
    }

    private void printAllLottoNumbers(Lottos lottos) {
        outputView.outputPurchaseNumber(lottos.getNumberOfLottos());
        for (List<Integer> lotto : lottos.getAllLottoNumbers()) {
            outputView.outputLottoNumber(lotto);
        }
    }

    private void setWinningNumber() {
        WinningNumber winningNumber = new WinningNumber(inputView.inputWinningNumber());
        BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());
    }
}
