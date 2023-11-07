package lotto.controller;

import lotto.Lotto;
import lotto.LottoGameResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void launch() {
        int money = inputView.inputPurchaseMoney();

        List<Lotto> userLottos = lottoService.buyLotto(money);
        outputView.printPurchasedLottos(userLottos);

        Lotto winningLotto = inputView.inputWinningLotto();
        int bonusNumber = inputView.inputBonusNumber();

        LottoGameResult lottoGameResult = lottoService.getResultOfLottos(winningLotto, bonusNumber);
        outputView.printLottoResult(lottoGameResult);

        double profitRate = lottoGameResult.calculateProfitRate(money);
        outputView.printProfitRate(profitRate);
    }
}
