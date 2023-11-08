package lotto.module.application;


import static lotto.global.constant.Game.LOTTO_PRICE;

import lotto.module.domain.Lottos;

public class LottoService {

    private final Lottos lottos;

    public LottoService(Lottos lottos) {
        this.lottos = lottos;
    }

    public void inputAmount(Long amount) {
        int quantity = (int) (amount / LOTTO_PRICE);
    }

}