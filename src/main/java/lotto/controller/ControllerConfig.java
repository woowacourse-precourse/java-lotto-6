package lotto.controller;

import lotto.domain.AutoLottoCreateModel;
import lotto.domain.LottoMachine;
import lotto.service.LottoBuyService;
import lotto.view.inputview.LottoBuyInputView;
import lotto.view.outputview.LottoBuyOutputView;

public class ControllerConfig {
    private ControllerConfig() {
    }

    public static Controller createLottoBuyController() {
        return new LottoBuyController(new LottoBuyInputView(), new LottoBuyOutputView(),
                new LottoBuyService(new LottoMachine(new AutoLottoCreateModel())));
    }
}
