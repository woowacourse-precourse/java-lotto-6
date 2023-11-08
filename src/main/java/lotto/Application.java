package lotto;

import lotto.domain.Judgement;
import lotto.view.InputView;
import lotto.controller.LottoController;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        LottoController lottoController = new LottoController(inputView(), outputView(), judgement());
        lottoController.run();

    }

    private static InputView inputView() {
        return new InputView();
    }

    private static OutputView outputView() {
        return new OutputView();
    }


    private static Judgement judgement() {
        return new Judgement();
    }
}
