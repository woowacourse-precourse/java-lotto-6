package lotto.controller;

import java.util.List;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.service.LottoService;
import lotto.model.Lotto;
import lotto.util.Validator;

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
        getBonusNumber(inputLotto);
    }

    private void getBonusNumber(Lotto inputLotto) {
        int bonusNumber = inputView.getBonusNumber();
        Validator.checkAlreadyExist(inputLotto, bonusNumber);

    }

    private void getLottoResult() {

    }


}
