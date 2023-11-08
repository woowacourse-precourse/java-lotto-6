package lotto;

import lotto.controller.LottoGameController;
import lotto.domain.Repeater;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Repeater repeater = new Repeater(outputView::printErrorMessage);
        LottoGameController lottoGameController = new LottoGameController(inputView, outputView, repeater);

        lottoGameController.play();
    }
}
