package lotto.controller;

import java.util.List;
import lotto.domain.Amount;
import lotto.domain.BuyerLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.domain.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        LottoShop lottoShop = setting();
        createBuyerLotto(lottoShop);
    }

    private LottoShop setting() {
        return new LottoShop(new RandomNumberGenerator());
    }

    private BuyerLotto createBuyerLotto(LottoShop lottoShop) {
        Amount amount = generateAmount();
        List<Lotto> createBuyerLotto = lottoShop.createByBuyerLotto(amount);
        OutputView.printBuyerLotto(createBuyerLotto.size(), createBuyerLotto);
        return new BuyerLotto(createBuyerLotto);
    }

    private Amount generateAmount() {
        int amount = InputView.readPurchaseAmount();
        return new Amount(amount);
    }
}
