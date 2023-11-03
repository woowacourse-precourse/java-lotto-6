package lotto.controller;

import java.util.List;
import lotto.domain.Amount;
import lotto.domain.BuyerLotto;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final LottoShop lottoShop;

    public LottoController(LottoShop lottoShop) {
        this.lottoShop = lottoShop;
    }

    private BuyerLotto createBuyerLotto(LottoShop lottoShop) {
        Amount amount = generateAmount();
        List<Lotto> createBuyerLotto = lottoShop.createByBuyerLotto(amount);
        OutputView.printBuyerLotto(createBuyerLotto.size(), createBuyerLotto);
        return new BuyerLotto(createBuyerLotto);
    }

    private Amount generateAmount() {
        while (true) {
            try {
                int amount = InputView.readPurchaseAmount();
                return new Amount(amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> generateWinningLotto() {
        while (true) {
            try {
                return InputView.readWinnerLottoNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
