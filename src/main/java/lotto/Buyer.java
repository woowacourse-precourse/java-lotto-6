package lotto;

import java.util.List;

public class Buyer {

    private final List<Lotto> lottos;

    public Buyer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void buy() {

        //TODO 판매처에서 로또를 구매
    }

    public void check() {

        //TODO 로또 위원회로부터 당첨 여부 조회
    }

    public void calculate() {

        //TODO 수익률 계산
    }

}
