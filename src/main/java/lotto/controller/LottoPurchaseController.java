package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoShop;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoPurchaseController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final LottoShop lottoShop = new LottoShop();

    public List<Lotto> purchase(int userPayment) {
        List<Lotto> purchasedLotto = purchaseLotto(userPayment);
        purchasedLotto.forEach(this::printPurchasedLotto);
        return purchasedLotto;
    }

    private List<Lotto> purchaseLotto(int payment) {
        try {
            return lottoShop.sell(payment);
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return purchaseLotto(payment);
        }
    }

    private void printPurchasedLotto(Lotto purchasedLotto) {
        List<Integer> lottoNumbers = purchasedLotto.getNumbers().stream().toList();
        outputView.printPurchasedLotto(lottoNumbers);
    }
}
