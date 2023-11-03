package lotto.controller;

import lotto.domain.*;
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
        LottoMoney money = inputView.getLottoMoney();
        LottoBundle lottoBundle = lottoService.buyLottoBundle(money);
        outputView.printLottoBundle(lottoBundle);
        AnswerLotto answerLotto = getAnswerLotto();
        LottoResult result = lottoService.calculateResult(lottoBundle, answerLotto);
    }

    private AnswerLotto getAnswerLotto() {
        Lotto answerLotto = inputView.getAnswerLotto();
        BonusNumber bonusNumber = inputView.getBonusNumber(answerLotto);
        return new AnswerLotto(answerLotto, bonusNumber);
    }

}
