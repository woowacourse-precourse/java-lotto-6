package lotto.controller;

import lotto.domain.Budget;
import lotto.domain.LottoSize;
import lotto.domain.Lottos;
import lotto.service.LottoService;
import lotto.view.GameView;

public class LottoController {
    private volatile static LottoController INSTANCE;
    private final LottoService lottoService;
    private final GameView gameView;

    private LottoController() {
        lottoService = LottoService.getInstance();
        gameView = GameView.getInstance();
    }

    public static LottoController getInstance() {
        if (INSTANCE == null) {
            synchronized (LottoController.class) {
                createInstance();
            }
        }

        return INSTANCE;
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LottoController();
        }
    }

    public Lottos createLottos(final Budget budget) {
        Lottos lottos = lottoService.createLottos(budget);
        LottoSize lottosSize = lottoService.getLottosSize(lottos);
        gameView.printLottosSize(lottosSize.toString());

        return lottos;
    }

    public void printLottos(final Lottos lottos) {
        String lottosNumbers = lottoService.getLottosNumbers(lottos);

        gameView.printLottosNumbers(lottosNumbers);
    }
}
