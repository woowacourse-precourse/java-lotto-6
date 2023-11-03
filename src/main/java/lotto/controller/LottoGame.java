package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.PrizeResult;
import lotto.domain.Rate;
import lotto.domain.UserLotto;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void gameStart() {
        int purchaseAmount = inputView.purchaseAmount();
        UserLotto user = generatedUserLotto(purchaseAmount);

        for (Lotto lotto : user.getUserLottoNumber()) {
            outputView.printUserLottoNumbers(lotto.getNumbers());
        }

        List<Integer> winNumbers = inputView.lottoNumbers();
        int bonusNumber = inputView.bonusNumber();
        WinningLotto winningLotto = generatedWinningLotto(winNumbers, bonusNumber);

        PrizeResult lottoResult = calculateResult(winningLotto, user);

        Rate rate = generatedRate(purchaseAmount, lottoResult);
    }

    private UserLotto generatedUserLotto(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        outputView.printCount(purchaseAmount / 1000);
        return new UserLotto(lottoCount);
    }

    private WinningLotto generatedWinningLotto(List<Integer> winNumber, int bonusNumber) {
        return new WinningLotto(winNumber, bonusNumber);
    }

    private PrizeResult calculateResult(WinningLotto winningLotto, UserLotto userLotto) {
        PrizeResult lottoResult = new PrizeResult();
        lottoResult.calcPrizeResult(winningLotto, userLotto);
        outputView.printPrizeCount(lottoResult.getPrizeResult());
        return lottoResult;
    }

    private Rate generatedRate(int purchaseAmount, PrizeResult lottoResult) {
        Rate rate = new Rate(purchaseAmount, lottoResult);
        outputView.printRate(rate.getRate());
        return rate;

    }
}
