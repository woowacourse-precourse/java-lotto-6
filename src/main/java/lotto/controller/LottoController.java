package lotto.controller;

import lotto.constant.LottoConfig;
import lotto.domain.*;
import lotto.view.InputView;

import java.util.List;

import static lotto.view.OutputView.*;

public class LottoController {
    public void run() {
        PurchaseLotto purchaseLotto = getPurChaseAmount();
        int lottoCount = purchaseLotto.getLottoCount();
        printPurchaseLottoCount(lottoCount);

        GenerateLotto generateLotto = getLottoTickets(lottoCount);
        List<Lotto> lottos = generateLotto.getLottos();
        printLottoTickets(lottos);

        WinningLotto winningLotto = getWinningLotto();
        List<Integer> winnerNumber = winningLotto.getWinnerNumber();

        BonusLotto bonusLotto = getBonusLotto(winningLotto.getWinnerNumber());
        int bonusNumber = bonusLotto.getBonusLotto();

        ResultLotto resultLotto = new ResultLotto();
        for (Lotto lotto : lottos) {
            resultLotto.addResult(lotto, winnerNumber, bonusNumber);
        }
        printMatchLotto(resultLotto);

        printProfitRate(resultLotto, purchaseLotto.getLottoCount() * LottoConfig.PURCHASE_AMOUNT_UNIT);
    }

    private PurchaseLotto getPurChaseAmount() {
        while (true) {
            try {
                printInputPurchaseAmount();
                String amount = InputView.inputPurchaseAmount();
                return new PurchaseLotto(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private GenerateLotto getLottoTickets(int lottoCount) {
       return new GenerateLotto(lottoCount);
    }

    private WinningLotto getWinningLotto() {
        while (true) {
            try {
                printInputWinnerNumbers();
                String winnerNumbers = InputView.inputWinnerNumbers();
                return new WinningLotto(winnerNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private BonusLotto getBonusLotto(List<Integer> winnerNumber) {
        while (true) {
            try {
                printInputBonusNumber();
                String bonusNumber = InputView.inputBonusNumbers();
                return new BonusLotto(bonusNumber, winnerNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}

