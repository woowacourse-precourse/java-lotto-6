package lotto.controller;

import lotto.domain.*;
import lotto.dto.LottoBundle;
import lotto.dto.LottoResult;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        LottoBundle lottoBundle = buyLottoBundle();
        outputView.printLottoBundle(lottoBundle);

        WinningLotto winningLotto = getAnswerLotto();

        LottoResult result = lottoService.calculateResult(lottoBundle, winningLotto);
        outputView.printLottoResult(result);
    }

    private LottoBundle buyLottoBundle() {
        LottoMoney money = inputView.getLottoMoney();
        return lottoService.buyLottoBundle(money);
    }

    private WinningLotto getAnswerLotto() {
        Lotto answerLotto = inputView.getAnswerLotto();
        BonusNumber bonusNumber = inputView.getBonusNumber(answerLotto);
        return new WinningLotto(answerLotto, bonusNumber);
    }

}
