package lotto.controller;

import lotto.domain.AutoLottoCreateModel;
import lotto.domain.LottoMachine;
import lotto.service.LottoBuyService;
import lotto.view.inputview.LottoBuyInputView;
import lotto.view.inputview.WinningLottoInputView;
import lotto.view.outputview.LottoBuyOutputView;
import lotto.view.outputview.LottoResultOutputView;
import lotto.view.outputview.WinningLottoOutputView;

public class ControllerConfig {
    private ControllerConfig() {
    }

    public static Controller createLottoBuyController() {
        return new LottoBuyController(new LottoBuyInputView(), new LottoBuyOutputView(),
                new LottoBuyService(new LottoMachine(new AutoLottoCreateModel())));
    }

    public static Controller createWinningLottoController() {
        return new WinningLottoController(new WinningLottoInputView(), new WinningLottoOutputView());
    }

    public static Controller createLottoResultController() {
        return new LottoResultController(new LottoResultOutputView());
    }
}
