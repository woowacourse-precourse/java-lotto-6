package lotto;

import lotto.Controller.LottoController;
import lotto.Model.LottoMachine;
import lotto.Model.LottoResultGenerator;
import lotto.Model.LottoVendingMachine;
import lotto.View.InputView;
import lotto.View.OutputView;
import lotto.View.View;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        View view = new View(new InputView(), new OutputView());
        LottoMachine lottoMachine = new LottoMachine(new LottoVendingMachine(), new LottoResultGenerator());
        LottoController lottoController = new LottoController(view, lottoMachine);
        lottoController.run();
    }
}
