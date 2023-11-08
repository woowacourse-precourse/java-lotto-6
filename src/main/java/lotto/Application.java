package lotto;

import lotto.view.BillAcceptor;
import lotto.view.LottoNumberInput;
import lotto.view.Screen;

public class Application {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine(new Screen(), new BillAcceptor(), new LottoNumberInput());
        lottoMachine.start();
    }
}
