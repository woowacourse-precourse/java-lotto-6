package lotto;

import static lotto.global.constant.LottoConstant.LOTTO_PRICE;

import lotto.domain.lotto.LottoGame;
import lotto.domain.lotto.LottoMachine;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView(outputView);

        LottoGame lottoGame = new LottoGame(inputView, outputView, new LottoMachine(LOTTO_PRICE));
        lottoGame.run();
    }
}
