package lotto;

import lotto.controller.LottoController;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = new LottoController(new InputView(), new OutputView(), new LottoService());
        while (true) {
            if (loopGame(lottoController)) {
                break;
            }
        }
    }

    private static boolean loopGame(LottoController lottoController) {
        try {
            boolean finish = lottoController.run();
            if (finish) {
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
