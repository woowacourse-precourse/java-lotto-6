package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoMachine;
import lotto.domain.Money;
import lotto.domain.NumberGenerator;
import lotto.domain.RandomNumberGenerator;

public class Application {
    public static void main(String[] args) {
        Money lottoPrice = new Money(1000);
        NumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        LottoMachine lottoMachine = new LottoMachine(lottoPrice, randomNumberGenerator);
        LottoController lottoController = new LottoController(lottoMachine);
        lottoController.startGame();
    }
}
