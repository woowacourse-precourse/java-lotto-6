package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.stream.IntStream;

public class LottoController {
    private LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

    private Amount amount;
    private Buyer buyer;

    public void play() {
        buyLotto();
    }

    private void buyLotto() {
        setAmount();
        this.buyer = new Buyer(new Lottos(IntStream
                        .range(0, this.amount.buyCount())
                        .mapToObj(i -> new Lotto(lottoNumberGenerator.pickUniqueNumbers()))
                        .toList()
        ));
        OutputView.purchaseLottos(buyer);
    }
    private void setAmount() {
        this.amount = new Amount(getPurchaseAmount());
    }

    private double getPurchaseAmount() {
        return InputView.getPurchaseAmount();
    }
}
