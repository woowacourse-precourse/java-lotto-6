package lotto.domain.controller;

import lotto.domain.model.Lotto;
import lotto.domain.model.LottoSaleSystem;
import lotto.domain.model.LottoWinnerSystem;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private List<Lotto> purchasedLotto;
    private LottoSaleSystem lottoSaleSystem;
    private LottoWinnerSystem lottoWinnerSystem;

    public LottoController() {
        purchasedLotto = new ArrayList<>();
        lottoSaleSystem = new LottoSaleSystem();
        lottoWinnerSystem = new LottoWinnerSystem();
    }

    public void start() {
        lottoSaleSystem.isValidMoney(InputView.inputPurchaseMoney());

        OutputView.printPurchaseCount(lottoSaleSystem.getPurchaseCount());
        generateLotto(lottoSaleSystem.getPurchaseCount());
        OutputView.printPurchasedLotto(purchasedLotto);

        List<Integer> winNumber = lottoWinnerSystem.isValidWinNumber(InputView.inputWinningNumber());
        List<Integer> bonusNumber = lottoWinnerSystem.isValidBonusNumber(InputView.inputBonusNumber(), winNumber);

        lottoWinnerSystem.isWinnerLotto(purchasedLotto, winNumber, bonusNumber);
        lottoWinnerSystem.printLottoResult();
        OutputView.printProfit(LottoSaleSystem.calculateProfit());
    }

    private void generateLotto(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            Lotto newLotto = new Lotto(Lotto.generateLottoNumber());
            purchasedLotto.add(newLotto);
        }
    }
}
