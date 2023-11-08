package lotto;

import lotto.controller.MainController;
import lotto.service.StatisticsService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {

    public static void main(String[] args) {
        ApplicationConfiguration configuration = new ApplicationConfiguration();
        InputView inputView = configuration.inputView();
        OutputView outputView = configuration.outputView();
        StatisticsService statisticsService = configuration.statisticsService();

        MainController mainController = new MainController(inputView, outputView, statisticsService);
        mainController.run();
    }
}
