package lotto.controller;

import lotto.model.LottoService;
import lotto.model.Result;
import lotto.model.dto.PayDTO;
import lotto.model.dto.WinningNumDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(){
        PayDTO payDTO = InputView.readPayment();
        this.lottoService = LottoService.buyLottos(payDTO);
        printPurchasedLottos(payDTO.getNumberOfLotto());
    }

    private void printPurchasedLottos(int numberOfLotto) {
        String resultOfPurchasedLottos = lottoService.getPurchasedLottos();
        OutputView.printPurchasedLottos(numberOfLotto, resultOfPurchasedLottos);
    }

    public void checkResult() {
        WinningNumDTO winningNumDTO = readWinningNums();
        Result result = lottoService.checkResult(winningNumDTO);
        OutputView.printResult(result);
    }

    public WinningNumDTO readWinningNums() {
        return InputView.readWinningNums();
    }
}
