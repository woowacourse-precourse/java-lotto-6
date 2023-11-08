package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.LottoLover;
import lotto.view.LottoView;

public class LottoController {

    public void giveMoneyTo(LottoLover buyer) {
        boolean isFailed = true;
        while (isFailed) {
            try {
                int moneyAmount = LottoView.requestMoneyToUser();
                buyer.earnMoneySomehow(moneyAmount);
                isFailed = false;
            } catch (IllegalArgumentException e) {
                // 메시지 출력 후 다시 입력하도록 한다.
                System.out.println("[Error] " + e);
            }
        }
    }

    public void brag(LottoLover lottoLover) {
        List<Lotto> lookAtThis
                = lottoLover.bragAboutMyLottoButYouAreNotAllowedToTouchIt();
        LottoView.printPurchaseList(lookAtThis);
    }

    public void drawResult() {
        List<Integer> winningNumbers = LottoView.requestWinningNumbers();
        int bonusNumber = LottoView.requestBonusNumber();
    }
}
