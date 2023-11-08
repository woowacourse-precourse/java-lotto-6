package lotto.controller;

import lotto.domain.User;
import lotto.domain.WinningNumbers;
import lotto.view.LottoGameInputView;
import lotto.view.LottoGameOutputView;

public class LottoGameController {

    User user;
    WinningNumbers winningNumbers;
    LottoGameInputView lottoGameInputView = new LottoGameInputView();
    LottoGameOutputView lottoGameOutputView = new LottoGameOutputView();

    public void run() {
        user = new User(lottoGameInputView.requestPurchaseAmount());
        lottoGameOutputView.printPurchaseLotto(user);
        winningNumbers = new WinningNumbers(lottoGameInputView.requestLottoWinningBonus());
        winningNumbers.setBonusNumber(lottoGameInputView.requestLottoWinningBonus(winningNumbers.getWinningLottoNumbers()));
        winningNumbers.compareWithUserLotto(user.getLottoList(), user.getMoney());
        lottoGameOutputView.printTotalLottoResult(winningNumbers.countTotalLottoPrizes(), winningNumbers.totalProfitMargin());
    }
}