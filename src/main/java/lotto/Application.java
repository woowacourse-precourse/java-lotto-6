package lotto;

import lotto.domain.*;
import lotto.facade.LottoGameFacade;
import lotto.input.console.UserConsoleInputAdapter;
import lotto.output.console.LottoGameViewConsoleOutputPort;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        LottoFactory lottoFactory = new LottoFactory(numberGenerator);

        LottoGameFacade lottoGameFacade = new LottoGameFacade(
                new UserConsoleInputAdapter(),
                new LottoGameViewConsoleOutputPort(),
                new LottoMarket(lottoFactory),
                new LottoProfitRateCalculator()
        );

        lottoGameFacade.game();
    }
}
