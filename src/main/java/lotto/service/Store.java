package lotto.service;

import static lotto.service.LottoGenerator.generateAutoLotto;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.impl.LottoBuyView;

public class Store {
    private LottoBuyView lottoBuyView;

    public Store(LottoBuyView lottoBuyView) {
        this.lottoBuyView = lottoBuyView;
    }

    public Lottos sell() {
        Money money = requestMoneyAmount();
        Lottos lottos = lottoGenerate(money);
        informLotto(lottos);

        return lottos;
    }

    private Lottos lottoGenerate(Money money) {
        int lottoCount = countLotto(money);

        Lottos lottos = new Lottos();
        for (int count = 0; count < lottoCount; count++) {
            lottos.addLotto(generateAutoLotto());
        }

        return lottos;
    }

    private int countLotto(Money money) {
        return money.calculateCount(Money.LOTTO_PRICE);
    }

    private void informLotto(Lottos lottos) {
        lottoBuyView.outputView(lottos);
    }

    private Money requestMoneyAmount(){
        return (Money) lottoBuyView.inputView();
    }

}
