package lotto.controller;

import java.util.List;
import lotto.model.LottoService;
import lotto.model.Ranking;
import lotto.model.Result;
import lotto.model.dto.PayDTO;
import lotto.model.dto.WinningNumDTO;
import lotto.view.AfterScreen;
import lotto.view.BeforeScreen;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(){
        int numberOfLotto = readPayment();
        this.lottoService = LottoService.buyLottos(numberOfLotto);
        printPurchasedLottos(numberOfLotto);
    }

    private void printPurchasedLottos(int numberOfLotto) {
        String resultOfPurchasedLottos = lottoService.getPurchasedLottos();
        BeforeScreen.printPurchasedLottos(numberOfLotto, resultOfPurchasedLottos);
    }

    public int readPayment(){
        PayDTO pay = BeforeScreen.readPayment();
        return pay.getNumberOfLotto();
    }

    public void checkResult() {
        WinningNumDTO winningNumDTO = readWinningNums();
        Result result = new Result(lottoService.checkResult(winningNumDTO));
        AfterScreen.printResult(result);
    }

    public WinningNumDTO readWinningNums() {
        return BeforeScreen.readWinningNums();
    }
}
