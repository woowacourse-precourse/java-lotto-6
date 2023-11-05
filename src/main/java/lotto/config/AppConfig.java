package lotto.config;

import lotto.adapter.IoAdapter;
import lotto.adapter.impl.StandardIoAdapter;
import lotto.game.Game;
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

    public Game game() {
        return new LottoGame(ioAdapter(), lottoProduceService(), validateService(), judgeService());
    }
}
