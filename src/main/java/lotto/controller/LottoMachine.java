package lotto.controller;

import lotto.controller.handler.DrawHandler;
import lotto.controller.machine.NumberGenerator;
import lotto.controller.user.LottoPurchase;
import lotto.domain.Lotto;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoMachine {
    private List<Lotto> lottos;

    private void createLottos(int count) {
        NumberGenerator numberGenerator = new NumberGenerator();
        lottos = numberGenerator.createLottos(count);
    }

    private void purchase(InputView inputView, OutputView outputView) {
        LottoPurchase lottoPurchase = new LottoPurchase(inputView);

        lottoPurchase.purchase();
        createLottos(lottoPurchase.getCount());

        outputView.showLottoCount(lottoPurchase.getCount());
        outputView.showLottos(lottos);
    }

    public void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        DrawHandler drawHandler = new DrawHandler(inputView);

        purchase(inputView, outputView);
        drawHandler.drarw();
    }
}
