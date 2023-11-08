package lotto.controller;

import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import lotto.domain.Price;
import lotto.view.InputPurchaseAmountView;
import lotto.view.InputWinningNumberView;

public class LottoController {

    private Price getLottoPrice(){
        InputPurchaseAmountView inputPurchaseAmountView = new InputPurchaseAmountView();
        int purchaseAmount = inputPurchaseAmountView.inputAmountView();
        return new Price(purchaseAmount);
    }

    private Lottos getLottos(Price price) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        return new Lottos(lottoGenerator.LottosGenerator(price.getPrice()));
    }
}
