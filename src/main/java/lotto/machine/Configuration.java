package lotto.machine;

import lotto.lotto.controller.LottoController;
import lotto.lotto.repository.LottoRepository;
import lotto.lotto.repository.LottoRepositoryImpl;
import lotto.lotto.service.LottoService;
import lotto.lotto.service.LottoServiceImpl;
import lotto.statistics.controller.StatisticsController;
import lotto.statistics.repository.StatisticsRepository;
import lotto.statistics.repository.StatisticsRepositoryImpl;
import lotto.statistics.service.StatisticsService;
import lotto.statistics.service.StatisticsServiceImpl;
import lotto.view.controller.ViewController;
import lotto.view.service.ViewInputService;
import lotto.view.service.ViewInputServiceImpl;
import lotto.view.service.ViewOutputService;
import lotto.view.service.ViewOutputServiceImpl;

public class Configuration {

    public LottoMachine init() {
        return new LottoMachine(viewController(), lottoController());
    }

    // View
    public ViewController viewController() {
        return new ViewController(viewInputService(), viewOutputService());
    }

    public ViewInputService viewInputService() {
        return new ViewInputServiceImpl();
    }

    public ViewOutputService viewOutputService() {
        return new ViewOutputServiceImpl();
    }

    // Lotto
    public LottoController lottoController() {
        return new LottoController(lottoService());
    }

    public LottoService lottoService() {
        return new LottoServiceImpl(lottoRepository());
    }

    public LottoRepository lottoRepository() {
        return new LottoRepositoryImpl();
    }

    // Statistics
    public StatisticsController statisticsController() {
        return new StatisticsController(statisticsService());
    }

    public StatisticsService statisticsService() {
        return new StatisticsServiceImpl(statisticsRepository());
    }

    public StatisticsRepository statisticsRepository() {
        return new StatisticsRepositoryImpl();
    }
}
