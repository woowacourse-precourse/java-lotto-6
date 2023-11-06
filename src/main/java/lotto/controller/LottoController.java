package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.WinningNumbers;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

import static lotto.domain.LottoConst.*;

public class LottoController {

    private final LottoService lottoService;
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController(LottoService lottoService, InputView inputView, ResultView resultView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void startLotto() {

        int input = inputView.inputPurchaseMoney();
        int buyCount = lottoService.getBuyCount(input);

        List<Lotto> myLottos = Lotto.createMyLottos(buyCount);

        resultView.printLottos(myLottos);

        WinningNumbers winningNums = inputView.inputWinningNums();

        LottoResult lottoResult = lottoService.calculateResult(myLottos, winningNums);

        resultView.printResult(lottoResult, input);
    }
}
