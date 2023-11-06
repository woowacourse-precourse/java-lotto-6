package lotto;

import lotto.repository.PrizeMoneyRepository;
import lotto.service.StatisticsService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class ApplicationConfiguration {

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public StatisticsService statisticsService() {
        return new StatisticsService(prizeMoneyRepository());
    }

    private PrizeMoneyRepository prizeMoneyRepository() {
        return new PrizeMoneyRepository();
    }
}
