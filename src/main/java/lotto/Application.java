package lotto;

import lotto.controller.MainController;
import lotto.repository.PrizeMoneyRepository;
import lotto.service.StatisticsService;
import lotto.view.InputView;
import lotto.view.MessageGenerator;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        MainController mainController = new MainController(new InputView(), new OutputView(new MessageGenerator()), new StatisticsService(new PrizeMoneyRepository()));
        mainController.run();
    }
}
