package lotto.config;

import lotto.CommaParser;
import lotto.ConsoleReceiver;
import lotto.ConsoleWriter;
import lotto.InputReceiver;
import lotto.InputView;
import lotto.OutputView;
import lotto.OutputWriter;
import lotto.Parser;
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
