package lotto.controller;

import java.util.List;
import lotto.factory.LottoFactory;
import lotto.factory.UserLotteriesFactory;
import lotto.factory.WinningLottoFactory;
import lotto.model.LottoNumbersGenerator;
import lotto.model.UserLotteries;
import lotto.model.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoDrawController {

    private final InputView inputView;
    private final OutputView outputView;
    private final UserLotteriesFactory userLotteriesFactory;
    private final LottoFactory lottoFactory;
    private final WinningLottoFactory winningLottoFactory;

    public LottoDrawController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoFactory = new LottoFactory(new LottoNumbersGenerator());
        this.userLotteriesFactory = new UserLotteriesFactory(lottoFactory);
        this.winningLottoFactory = new WinningLottoFactory(lottoFactory);
    }

    public void startDraw() {
        Integer purchaseAmount = inputView.getPurchaseAmount();
        Integer countOfPurchasedLotto = UserLotteriesFactory.calculateCountOfPurchasedLotto(purchaseAmount);
        UserLotteries userLotteries = userLotteriesFactory.createFromPurchaseAmount(purchaseAmount);

        showUserLottoDetails(countOfPurchasedLotto, userLotteries);
        WinningLotto winningLotto = createWinningLotto();
    }

    private void showUserLottoDetails(Integer countOfPurchasedLotto, UserLotteries userLotteries) {
        outputView.printPurchasedCountMessage(countOfPurchasedLotto);
        userLotteries.sortAscendingAllLotto();
        outputView.printUserLotteries(userLotteries);
    }

    private WinningLotto createWinningLotto() {
        List<String> drawnNumbers = inputView.getDrawnNumbers();
        Integer bonusNumber = inputView.getBonusNumber(drawnNumbers);
        return winningLottoFactory.createWinningLotto(drawnNumbers, bonusNumber);
    }
}