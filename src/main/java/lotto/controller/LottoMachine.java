package lotto.controller;

import lotto.controller.machine.NumberGenerator;
import lotto.controller.user.LottoDraw;
import lotto.controller.user.LottoPurchase;
import lotto.domain.Lotto;
import lotto.model.LottoReceipt;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private List<Lotto> createLottos(int purchaseCount) {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto;

        for (int count = 0; count < purchaseCount; count++) {
            lotto = numberGenerator.createLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    private void drawLotto(InputView inputView) {
        LottoDraw lottoDraw = new LottoDraw(inputView);
        lottoDraw.draw();
    }

    public void start() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoPurchase lottoPurchase = new LottoPurchase(inputView);

        lottoPurchase.purchase();
        List<Lotto> lottos = createLottos(lottoPurchase.getCount());

        outputView.showLottoCount(lottoPurchase.getCount());
        outputView.showLottos(lottos);

        drawLotto(inputView);
    }
}
