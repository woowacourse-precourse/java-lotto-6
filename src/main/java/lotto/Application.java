package lotto;

import lotto.controller.LottoMachine;
import lotto.domain.lottery.Lottos;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        Lottos lottos = lottoMachine.purchase();
    }
}
