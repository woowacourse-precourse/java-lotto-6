package lotto.configuration;

import lotto.controller.LottoGameController;
import lotto.repository.MemoryLottoGameRepository;
import lotto.repository.Repository;
import lotto.service.LottoGameService;
import lotto.service.LottoGameServiceImpl;
import lotto.view.ConsoleInputView;
import lotto.view.ConsoleOutputView;
import lotto.view.InputView;
import lotto.view.OutputView;

public class AppConfig implements Config {

    private static class LazyHolder { //final instance로 동시성 문제 해결
        private static final AppConfig INSTANCE = new AppConfig();
        private static final LottoGameController lottoGameController = createLottoGameController();
        private static final InputView inputView = createInputView();
        private static final OutputView outputView = createOutputView();
        private static final LottoGameService lottoGameService = createLottoGameService();
        private static final Repository lottoGameRepository = createLottoGameRepository();

        private static LottoGameController createLottoGameController() {
            return new LottoGameController(
                    inputView,
                    outputView,
                    lottoGameService);
        }

        private static InputView createInputView() {
            return new ConsoleInputView();
        }

        private static OutputView createOutputView() {
            return new ConsoleOutputView();
        }

        private static LottoGameService createLottoGameService() {
            return new LottoGameServiceImpl(lottoGameRepository);
        }

        private static Repository createLottoGameRepository() {
            return new MemoryLottoGameRepository();
        }
    }

    public static AppConfig getInstance() {
        return LazyHolder.INSTANCE;
    }

    @Override
    public LottoGameController lottoGameController() {
        return LazyHolder.lottoGameController;
    }

    @Override
    public LottoGameService lottoGameService() {
        return LazyHolder.lottoGameService;
    }

    @Override
    public InputView inputView() {
        return LazyHolder.inputView;
    }

    @Override
    public OutputView outputView() {
        return LazyHolder.outputView;
    }

    @Override
    public Repository lottoGameRepository() {
        return LazyHolder.lottoGameRepository;
    }
}
