package lotto;

import lotto.domain.LottoMachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoMachine lottoMachine = new LottoMachine();
        int amount = lottoMachine.purchaseLotto();

        while (true) {
            if (lottoMachine.calculateAmount(amount) != -1) {
                break;
            }
            amount = lottoMachine.purchaseLotto();
        }
    }
}
