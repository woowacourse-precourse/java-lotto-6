package lotto.machine;

import lotto.lotto.controller.LottoController;
import lotto.lotto.repository.LottoRepository;
import lotto.lotto.repository.LottoRepositoryImpl;
import lotto.lotto.service.LottoService;
import lotto.lotto.service.LottoServiceImpl;
import lotto.statistic.controller.StatisticController;
import lotto.statistic.repository.StatisticRepository;
import lotto.statistic.repository.StatisticRepositoryImpl;
import lotto.statistic.service.StatisticService;
import lotto.statistic.service.StatisticServiceImpl;
import lotto.view.controller.ViewController;
import lotto.view.service.ViewInputService;
import lotto.view.service.ViewInputServiceImpl;
import lotto.view.service.ViewOutputService;
import lotto.view.service.ViewOutputServiceImpl;

public class Configuration {

    public LottoMachine init() {
        return new LottoMachine(viewController(), lottoController(), statisticsController());
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
    public StatisticController statisticsController() {
        return new StatisticController(statisticService());
    }

    public StatisticService statisticService() {
        return new StatisticServiceImpl(statisticRepository());
    }

    public StatisticRepository statisticRepository() {
        return new StatisticRepositoryImpl();
    }
}
