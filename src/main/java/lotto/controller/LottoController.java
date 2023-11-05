package lotto.controller;

import lotto.model.Lottos;
import lotto.model.Result;
import lotto.model.dto.PayDTO;
import lotto.model.dto.WinningNumDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final Lottos lottos;

    public LottoController() {
        PayDTO payDTO = InputView.readPayment();
        this.lottos = Lottos.buyLottos(payDTO.getNumberOfLotto());
        printPurchasedLottos(payDTO.getNumberOfLotto());
    }

    private void printPurchasedLottos(int numberOfLotto) {
        String resultOfPurchasedLottos = lottos.getPurchasedLottos();
        OutputView.printPurchasedLottos(numberOfLotto, resultOfPurchasedLottos);
    }

    public void checkResult() {
        WinningNumDTO winningNumDTO = readWinningNumsAndBonus();
        Result result = lottos.checkResult(winningNumDTO);
        OutputView.printResult(result);
    }

    public WinningNumDTO readWinningNumsAndBonus() {
        return InputView.readWinningNumsAndBonus();
    }
}
