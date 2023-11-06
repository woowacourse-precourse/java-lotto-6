package lotto.controller;

import lotto.generator.RandomUniqueListGenerator;
import lotto.model.Lotto;
import lotto.model.LottoGameManager;
import lotto.model.LottoOwner;
import lotto.model.PurchasePrice;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printEnterPurchaseAmount();
        PurchasePrice purchasePrice = PurchasePrice.from(inputView.getPurchaseAmount());
        LottoOwner lottoOwner = LottoOwner.of(purchasePrice, new RandomUniqueListGenerator());
        outputView.printLottosInfo(lottoOwner.getLottosInfo());
        WinningLotto winningLotto = WinningLotto.of(getWinningLotto(), getBonusNumber());
        outputView.printWinnerStatistics();
        LottoGameManager lottoGameManager = LottoGameManager.of(lottoOwner, winningLotto);
        outputView.printWinningStatistics(lottoGameManager.getWinningStatistics());
        outputView.printRateOfReturn(lottoGameManager.getRateOfReturn());
    }

    private Lotto getWinningLotto() {
        outputView.printEnterWinningNumbers();
        return Lotto.from(inputView.getWinningNumbers());
    }

    private int getBonusNumber() {
        outputView.printEnterBonusNumber();
        return inputView.getBonusNumber();
    }
}
