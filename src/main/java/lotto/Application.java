package lotto;

import lotto.controller.LottoGameManager;
import lotto.service.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoStore lottoStore = new LottoStore();

        LottoGameManager lottoGameManager = new LottoGameManager(inputView, outputView, lottoStore);

        lottoGameManager.play();
    }
}
