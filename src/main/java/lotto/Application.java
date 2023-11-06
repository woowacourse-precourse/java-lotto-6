package lotto;

import lotto.controller.LottoController;
import lotto.model.Referee;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = InputView.getInstance();
        inputView.printPurchaseMoneyMessage();

        Referee referee = new Referee();
        LottoController lottoController = new LottoController(referee);

        inputView.printWinningNumbersMessage();
        lottoController.createWinningLotto();

        lottoController.getLottoResult();
    }
}
