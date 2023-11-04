package lotto.controller;

import java.util.List;
import lotto.model.LottoService;
import lotto.model.Ranking;
import lotto.model.Result;
import lotto.model.dto.PayDTO;
import lotto.model.dto.WinningNumDTO;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(){
        int numberOfLotto = readPayment();
        this.lottoService = LottoService.buyLottos(numberOfLotto);
        printPurchasedLottos(numberOfLotto);
    }

    private void printPurchasedLottos(int numberOfLotto) {
        String resultOfPurchasedLottos = lottoService.getPurchasedLottos();
        OutputView.printPurchasedLottos(numberOfLotto, resultOfPurchasedLottos);
    }

    public int readPayment(){
        PayDTO pay = InputView.readPayment();
        return pay.getNumberOfLotto();
    }

    public void checkResult() {
        WinningNumDTO winningNumDTO = readWinningNums();
        Result result = new Result(lottoService.checkResult(winningNumDTO));
        OutputView.printResult(result);
    }

    public WinningNumDTO readWinningNums() {
        return InputView.readWinningNums();
    }
}
