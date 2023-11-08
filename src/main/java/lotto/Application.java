package lotto;

import lotto.service.LottoMachine;

public class Application {
    public static void main(String[] args) {
        try {
            LottoMachine lottoMachine = new LottoMachine();
            lottoMachine.start();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
