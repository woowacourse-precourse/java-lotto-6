package lotto;

import controller.LottoController;
import view.InputView;
import view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(inputView, outputView);

        lottoController.purchase();

        lottoController.setWinLotto();

        lottoController.checkLottoes();
    }
}
