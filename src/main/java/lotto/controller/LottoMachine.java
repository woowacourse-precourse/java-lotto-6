package lotto.controller;

import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private int lottoCount;

    private void purchaseLotto(InputView inputView) {
        LottoPurchase lottoPurchase = new LottoPurchase(inputView);
        int purchaseAmount = lottoPurchase.inputAmount();

        lottoCount = purchaseAmount / LOTTO_PRICE;
    }

    private List<Lotto> createLottos() {
        NumberGenerator numberGenerator = new NumberGenerator();
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto;

        for (int count = 0; count < lottoCount; count++) {
            lotto = numberGenerator.createLotto();
            lottos.add(lotto);
        }

        return lottos;
    }

    private void drawLotto(InputView inputView) {
        LottoDraw lottoDraw = new LottoDraw(inputView);
        lottoDraw.drawLotto();
    }

    public void start() {
        List<Lotto> lottos;
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        purchaseLotto(inputView);
        lottos = createLottos();

        outputView.showLottoCount(lottoCount);
        outputView.showLottos(lottos);

        drawLotto(inputView);
    }
}
