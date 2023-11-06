package lotto;

import lotto.repository.PrizeMoneyRepository;
import lotto.service.StatisticsService;
import lotto.view.InputView;
import lotto.view.MessageGenerator;
import lotto.view.OutputView;

public class ApplicationConfiguration {

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView(messageGenerator());
    }

    private MessageGenerator messageGenerator() {
        return new MessageGenerator();
    }

    public StatisticsService statisticsService() {
        return new StatisticsService(prizeMoneyRepository());
    }

    private PrizeMoneyRepository prizeMoneyRepository() {
        return new PrizeMoneyRepository();
    }
}
