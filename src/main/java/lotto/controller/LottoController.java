package lotto.controller;

import java.util.List;
import lotto.constant.LottoRanking;
import lotto.generator.RandomUniqueListGenerator;
import lotto.model.Lotto;
import lotto.model.LottoGameManager;
import lotto.model.LottoOwner;
import lotto.model.LottoResult;
import lotto.model.PurchasePrice;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        try {
            outputView.printEnterPurchaseAmount();
            PurchasePrice purchasePrice = PurchasePrice.from(inputView.getPurchaseAmount());
            List<Lotto> randomLottos = Lotto.createRandomLottos(purchasePrice, new RandomUniqueListGenerator());
            LottoResult lottoResult = LottoResult.from(LottoRanking.convertValuesIntoCounters());
            LottoOwner lottoOwner = LottoOwner.of(purchasePrice, randomLottos, lottoResult);
            outputView.printLottosInfo(lottoOwner.getLottosInfo());
            WinningLotto winningLotto = WinningLotto.of(getWinningLotto(), getBonusNumber());
            outputView.printWinnerStatistics();
            LottoGameManager lottoGameManager = LottoGameManager.of(lottoOwner, winningLotto);
            lottoGameManager.matchLottosWithWinningLotto();
            outputView.printWinningStatistics(lottoGameManager.getWinningStatistics());
            outputView.printRateOfReturn(lottoGameManager.getRateOfReturn());
        } catch (IllegalArgumentException | IllegalStateException e) {
            outputView.printText(e.getMessage());
        }
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
