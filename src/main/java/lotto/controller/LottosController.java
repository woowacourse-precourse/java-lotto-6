package lotto.controller;

import static lotto.view.constant.InputMessage.GET_WINNING_NUMBERS_MESSAGE;

import lotto.domain.LottoPurchase;
import lotto.domain.Lottos;
import lotto.service.LottosService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottosController {

    private final InputView inputView;
    private final LottosService lottosService;

    public LottosController() {
        this.inputView = new InputView();
        this.lottosService = new LottosService();
    }

    public Lottos getLottos(LottoPurchase lottoPurchase) {
        return lottosService.createLottos(lottoPurchase);
    }

    public String getWinningNumbers() {
        OutputView.printMessage(GET_WINNING_NUMBERS_MESSAGE.getMessage());
        return inputView.readWinningNumbers();
    }
}
