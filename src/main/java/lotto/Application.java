package lotto;

import lotto.view.NumberInput;
import lotto.view.Screen;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(new Screen(), new NumberInput());
        lottoMachine.start();
    }
}
