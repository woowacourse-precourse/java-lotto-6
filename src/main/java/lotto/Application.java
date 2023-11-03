package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoProcess;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        try {
            InputView inputView = new InputView();
            OutputView outputView = new OutputView();
            LottoProcess lottoProcess = new LottoProcess();
            LottoController lottoController = new LottoController(outputView, inputView, lottoProcess);
            
            lottoController.run();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
