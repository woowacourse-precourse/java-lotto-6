package lotto.controller;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.service.LottoService;
import lotto.model.Lotto;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void run() {
        purchaseLotto();
        getWinningNumbers();
    }

    private void purchaseLotto() {
        int money = inputView.getLottoPurchaseAmount();
        List<Lotto> lottos = LottoService.purchaseLotto(money);
        outputView.printNumberOfLotto(lottos);
    }

    private void getWinningNumbers() {
        Lotto inputLotto = inputView.getWinningNumbers();
    }

    private void getBonusNumber() {

    }

    private void getLottoResult() {

    }


}
