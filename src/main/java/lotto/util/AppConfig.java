package lotto.util;

import lotto.controller.LottoGameController;
import lotto.service.BuyCashService;
import lotto.service.LottoService;
import lotto.service.ResultService;
import lotto.view.InputView;
import lotto.view.OutputView;

public enum AppConfig {
    INSTANCE;

    private InputView inputView;
    private OutputView outputView;
    private BuyCashService buyCashService;
    private LottoService lottoService;
    private ResultService resultService;
    private LottoGameController lottoGameController;

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public BuyCashService buyCashService() {
        if (buyCashService == null) {
            buyCashService = new BuyCashService();
        }
        return buyCashService;
    }

    public LottoService lottoService() {
        if (lottoService == null) {
            lottoService = new LottoService();
        }
        return lottoService;
    }

    public ResultService resultService() {
        if (resultService == null) {
            resultService = new ResultService();
        }
        return resultService;
    }

    public LottoGameController lottoGameController() {
        if (lottoGameController == null) {
            lottoGameController = new LottoGameController(INSTANCE.inputView(), INSTANCE.outputView(),
                    INSTANCE.buyCashService(), INSTANCE.lottoService(), INSTANCE.resultService());
        }
        return lottoGameController;
    }


}
