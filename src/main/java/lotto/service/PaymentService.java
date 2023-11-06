package lotto.service;

import lotto.model.LottoCondition;
import lotto.model.Lottos;

public class Payment {
    private Lottos lottos;
    private final int price;
    private int lottoCount;

    public Payment(int price) {
        this.price = price;
    }

    private void payment(int price) {
        lottoCount = price / LottoCondition.UNIT.getNumber();
        this.lottos = new Lottos(lottoCount);
    }


}
