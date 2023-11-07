package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.type.LottoPrize;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Controller {
    private final LottoGame lottoGame;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller() {
        lottoGame = new LottoGame();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        int purchaseAmount = inputView.getPurchaseAmount();

        outputView.displayLotto(lottoGame.purchaseLottos(purchaseAmount));

        Lotto winningNumbers = inputView.getWinningNumbers();
        int bonusNumber = inputView.getBonusNumber(winningNumbers);

        LottoResult result = new LottoResult(lottoGame.getPurchasedLottos(), winningNumbers, bonusNumber);
        List<LottoPrize> results = result.calculateResults();

        outputView.displayResults(results);
        outputView.displayReturnRatio(result.calculateReturnRatio(results, purchaseAmount));
    }
}