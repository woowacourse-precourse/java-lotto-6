package lotto.controller;

import java.util.List;

import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.service.LottoService;
import lotto.model.Lotto;
import lotto.model.LottoResult;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void run() {
        List<Lotto> lottos = purchaseLotto();

        Lotto winningNumbers = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber();

        LottoResult result = LottoService.calculateResult(lottos, winningNumbers, bonusNumber);
        outputView.printWinningStatics(result);
    }

    private List<Lotto> purchaseLotto() {
        int money = inputView.getLottoPurchaseAmount();
        List<Lotto> lottos = LottoService.purchaseLotto(money);
        outputView.printNumberOfLotto(lottos);
        return lottos;
    }
}
