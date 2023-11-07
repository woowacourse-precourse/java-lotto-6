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
        EnterPurchaseMoney();
        OutputView.printPurchaseCount(lottoSaleSystem.getPurchaseCount());
        generateLotto(lottoSaleSystem.getPurchaseCount());
        OutputView.printPurchasedLotto(purchasedLotto);

        List<Integer> winNumber = EnterWinNumber();
        List<Integer> bonusNumber = EnterBonusNumber(winNumber);

        lottoWinnerSystem.isWinnerLotto(purchasedLotto, winNumber, bonusNumber);
        lottoWinnerSystem.printLottoResult();
        OutputView.printProfit(LottoSaleSystem.calculateProfit());
    }

    private List<Integer> EnterBonusNumber(List<Integer> winNumber) {
        try {
            List<Integer> bonusNumber = lottoWinnerSystem.isValidBonusNumber(InputView.inputBonusNumber(), winNumber);
            return bonusNumber;
        } catch (IllegalArgumentException errorMessage) {
            System.out.println(errorMessage.getMessage());
            return EnterBonusNumber(winNumber);
        }
    }

    private List<Integer> EnterWinNumber() {
        try {
            List<Integer> winNumber = lottoWinnerSystem.isValidWinNumber(InputView.inputWinningNumber());
            return winNumber;
        } catch (IllegalArgumentException errorMessage) {
            System.out.println(errorMessage.getMessage());
            return EnterWinNumber();
        }
    }

    private void EnterPurchaseMoney() {
        try {
            lottoSaleSystem.isValidMoney(InputView.inputPurchaseMoney());
        } catch (IllegalArgumentException errorMessage) {
            System.out.println(errorMessage.getMessage());
            EnterPurchaseMoney();
        }
    }

    private void generateLotto(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            Lotto newLotto = new Lotto(Lotto.generateLottoNumber());
            purchasedLotto.add(newLotto);
        }
    }
}
