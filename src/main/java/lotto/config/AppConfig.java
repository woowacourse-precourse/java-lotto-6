package lotto.config;

import lotto.adapter.IoAdapter;
import lotto.adapter.impl.StandardIoAdapter;
import lotto.game.Game;
import lotto.game.controller.MoneyController;
import lotto.game.controller.PrintController;
import lotto.game.controller.StatisticsController;
import lotto.game.controller.WalletController;
import lotto.game.controller.WinningLottoController;
import lotto.game.impl.LottoGame;
import lotto.service.JudgeService;
import lotto.service.LottoProduceService;
import lotto.service.SortService;
import lotto.service.ValidateService;
import lotto.service.impl.JudgeServiceImpl;
import lotto.service.impl.LottoProduceServiceImpl;
import lotto.service.impl.SortServiceImpl;
import lotto.service.impl.ValidateServiceImpl;

public class AppConfig {

    public ValidateService validateService() {
        return new ValidateServiceImpl();
    }

    public IoAdapter ioAdapter() {
        return new StandardIoAdapter();
    }

    public SortService sortService() {
        return new SortServiceImpl();
    }

    public LottoProduceService lottoProduceService() {
        return new LottoProduceServiceImpl(sortService(), ioAdapter());
    }

    public JudgeService judgeService() {
        return new JudgeServiceImpl();
    }

    public MoneyController moneyController() {
        return new MoneyController(ioAdapter(), validateService());
    }

    public PrintController printController() {
        return new PrintController(ioAdapter());
    }

    public StatisticsController statisticsController() {
        return new StatisticsController(judgeService());
    }

    public WalletController walletController() {
        return new WalletController(lottoProduceService());
    }

    public WinningLottoController winningLottoController() {
        return new WinningLottoController(ioAdapter(), validateService());
    }

    public Game game() {
        return new LottoGame(moneyController(), winningLottoController(), statisticsController(), printController(),
                walletController());
    }
}
