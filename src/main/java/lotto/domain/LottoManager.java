package lotto.domain;

import lotto.ui.Input;

public class LottoManager {

    public void run() {
        Input input = new Input();
        LottoDraw lottoDraw = new LottoDraw(input.purchasePrice());
        lottoDraw.configureNumbers();
        lottoDraw.printPurchaseHistory();

        input.winningNumbers();
        input.BonusNumber();

        LottoResult lottoResult = new LottoResult(lottoDraw.getLottos());
        lottoResult.configurePrizeCount(input.getWinningNumbers());
        lottoResult.printWinningHistory();
        lottoResult.printMyROI();
    }
}
