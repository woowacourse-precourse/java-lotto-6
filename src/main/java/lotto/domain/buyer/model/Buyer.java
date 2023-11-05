package lotto.domain.buyer.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;

public class Buyer {

    private List<Lotto> lottos;

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void tryBuy() {

        //TODO 구매할 로또 금액 입력
    }

    public void tryCheck() {

        //TODO 로또 위원회로부터 당첨 여부 조회
    }

    public void tryCalculate() {

        //TODO 수익률 계산
    }

}
