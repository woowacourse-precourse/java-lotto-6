package lotto.config;

import lotto.utils.CommaParser;
import lotto.io.ConsoleReceiver;
import lotto.io.ConsoleWriter;
import lotto.io.InputReceiver;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.io.OutputWriter;
import lotto.utils.Parser;
import lotto.utils.NumberGenerator;
import lotto.utils.ProfitRateCalculator;
import lotto.utils.ProfitRateTwoDecimalRoundCalculator;
import lotto.utils.RandomNumberGenerator;

public class AppConfig {

    public InputView inputView() {
        return new InputView(inputReceiver());
    }

    public Parser parser() {
        return new CommaParser();
    }

    public NumberGenerator numberGenerator() {
        return new RandomNumberGenerator(
                LottoGameRule.LOTTO_MIN_VALUE.value(),
                LottoGameRule.LOTTO_MAX_VALUE.value());
    }

    public ProfitRateCalculator profitRateCalculator() {
        return new ProfitRateTwoDecimalRoundCalculator();
    }

    public InputReceiver inputReceiver() {
        return new ConsoleReceiver();
    }

    public OutputWriter outputWriter() {
        return new ConsoleWriter();
    }

    public OutputView outputView() {
        return new OutputView(outputWriter());
    }
}
