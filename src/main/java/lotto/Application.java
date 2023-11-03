package lotto;

import controller.LottoController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
    	LottoController lottoCon = new LottoController();
    	lottoCon.buyLotto(new InputView(), new OutputView());
    }
}
