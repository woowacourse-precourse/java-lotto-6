package lotto.controller;

import lotto.domain.User;
import lotto.domain.LottoWinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    User user;
    LottoWinningNumbers lottoWinningNumbers;
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        user = new User(inputView.purchaseAmountMoney());
        outputView.printPurchaseLotto(user);
        lottoWinningNumbers = new LottoWinningNumbers(inputView.lottoWinningNumber());
        lottoWinningNumbers.lottoWinningBonusNumber(inputView.lottoWinningBonus(lottoWinningNumbers.noticeLottoWinningNumbers()));
        lottoWinningNumbers.compareWithUserLottoAndWinningLotto(user.getLottos(), user.getMoney());
        outputView.printTotalLottoResult(lottoWinningNumbers.countTotalLottoPrizes(), lottoWinningNumbers.totalProfitMargin());
    }
}
