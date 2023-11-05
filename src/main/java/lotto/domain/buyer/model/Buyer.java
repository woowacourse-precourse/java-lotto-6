package lotto.domain.buyer.model;

import lotto.domain.Lotto;

import java.util.List;

public class Buyer {

    private final List<Lotto> lottos;

    public Buyer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void tryBuy() {

        //TODO 판매처에서 로또를 구매
    }

    public void tryCheck() {

        //TODO 로또 위원회로부터 당첨 여부 조회
    }

    public void tryCalculate() {

        //TODO 수익률 계산
    }

}
