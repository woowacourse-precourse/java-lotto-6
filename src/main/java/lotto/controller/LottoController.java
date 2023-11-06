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

        List<Lotto> lottos = generateLottos(lottoCount);

        WinningLotto winningLotto = getWinningLotto();
        List<Integer> winnerNumber = winningLotto.getWinnerNumber();

        int bonusNumber = getBonusNumber(winningLotto);

        printMatchAndProfitRate(lottos, winnerNumber, bonusNumber, lottoCount);
    }

    private PurchaseLotto getPurChaseAmount() {
        while (true) {
            try {
                printInputPurchaseAmount();
                return new PurchaseLotto(InputView.inputPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> generateLottos(int lottoCount) {
        GenerateLotto generateLotto = getLottoTickets(lottoCount);
        List<Lotto> lottos = generateLotto.getLottos();
        printLottoTickets(lottos);
        return lottos;
    }

    private GenerateLotto getLottoTickets(int lottoCount) {
        return new GenerateLotto(lottoCount);
    }

    private WinningLotto getWinningLotto() {
        while (true) {
            try {
                printInputWinnerNumbers();
                return new WinningLotto(InputView.inputWinnerNumbers());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getBonusNumber(WinningLotto winningLotto) {
        while (true) {
            try {
                printInputBonusNumber();
                return new BonusLotto(InputView.inputBonusNumbers(), winningLotto).getBonusLotto();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printMatchAndProfitRate(List<Lotto> lottos, List<Integer> winnerNumber, int bonusNumber, int lottoCount) {
        ResultLotto resultLotto = getResultLotto(lottos, winnerNumber, bonusNumber);
        printMatchLotto(resultLotto);
        printProfitRate(resultLotto, lottoCount * LottoConfig.PURCHASE_AMOUNT_UNIT);
    }

    private ResultLotto getResultLotto(List<Lotto> lottos, List<Integer> winnerNumber, int bonusNumber) {
        ResultLotto resultLotto = new ResultLotto();
        for (Lotto lotto : lottos) {
            resultLotto.addResult(lotto, winnerNumber, bonusNumber);
        }
        return resultLotto;
    }
}
