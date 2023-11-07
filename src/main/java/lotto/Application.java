package lotto;

import lotto.controller.LottoController;
import lotto.domain.LottoShop;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        LottoShop lottoShop = new LottoShop();
        OutputView outputView = new OutputView();
        LottoController lottoController = new LottoController(inputView,lottoShop,outputView);
        lottoController.run();
    }
}
