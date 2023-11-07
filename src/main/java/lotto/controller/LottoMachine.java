package lotto.controller;

import lotto.controller.machine.NumberGenerator;
import lotto.controller.user.BonusDraw;
import lotto.controller.user.LottoDraw;
import lotto.controller.user.LottoPurchase;
import lotto.domain.Lotto;
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

    private void draw(InputView inputView) {
        LottoDraw lottoDraw = new LottoDraw(inputView);
        lottoDraw.draw();
    }

    private void drawBounsNumber(InputView inputView) {
        BonusDraw bonusDraw = new BonusDraw(inputView);
        bonusDraw.draw();
    }

    public void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        purchase(inputView, outputView);

        draw(inputView);
        drawBounsNumber(inputView);
    }
}
