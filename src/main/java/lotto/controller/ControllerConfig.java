package lotto.controller;

import lotto.controller.controllers.Controller;
import lotto.controller.controllers.LottoBuyController;
import lotto.controller.controllers.LottoResultController;
import lotto.controller.controllers.WinningLottoController;
import lotto.domain.AutoLottoCreateModel;
import lotto.domain.LottoMachine;
import lotto.service.LottoBuyService;
import lotto.view.inputview.LottoBuyInputView;
import lotto.view.inputview.WinningLottoInputView;
import lotto.view.outputview.LottoBuyOutputView;
import lotto.view.outputview.LottoResultOutputView;
import lotto.view.outputview.WinningLottoOutputView;

public final class ControllerConfig {
    private ControllerConfig() {
    }

    static Controller createLottoBuyController() {
        return new LottoBuyController(new LottoBuyInputView(), new LottoBuyOutputView(),
                new LottoBuyService(new LottoMachine(new AutoLottoCreateModel())));
    }

    static Controller createWinningLottoController() {
        return new WinningLottoController(new WinningLottoInputView(), new WinningLottoOutputView());
    }

    static Controller createLottoResultController() {
        return new LottoResultController(new LottoResultOutputView());
    }
}
