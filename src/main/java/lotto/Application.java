package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoFactory;
import lotto.domain.LottoMarket;
import lotto.domain.NumberGenerator;
import lotto.domain.RandomNumberGenerator;
import lotto.domain.LottoProfitRateCalculator;
import lotto.facade.LottoGameFacade;
import lotto.input.console.UserConsoleInputAdapter;
import lotto.output.console.LottoGameViewConsoleOutputPort;

public class Application {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        LottoFactory lottoFactory = new LottoFactory(numberGenerator);

        LottoGameFacade lottoGameFacade = new LottoGameFacade(
                new UserConsoleInputAdapter(Console::readLine),
                new LottoGameViewConsoleOutputPort(),
                new LottoMarket(lottoFactory),
                new LottoProfitRateCalculator()
        );

        lottoGameFacade.game();
    }
}
