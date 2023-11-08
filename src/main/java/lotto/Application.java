package lotto;

import lotto.domain.Game;
import lotto.domain.proxy.PrizeConfig;
import lotto.domain.proxy.PrizeHandler;
import lotto.utils.RandomGenerator;
import lotto.utils.RandomGeneratorImpl;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        PrizeHandler prizeHandler = PrizeConfig.getPrizeHandlerInstance();
        RandomGenerator randomGenerator = new RandomGeneratorImpl();
        Game game = new Game();
        OutputView outputView = new OutputView(inputView, randomGenerator, prizeHandler, game);
        outputView.start();
    }
}
