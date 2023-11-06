package lotto.controller;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private int lottoCount;

    private void purchaseLotto() {
        LottoPurchase lottoPurchase = new LottoPurchase();
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

    public void start() {
        List<Lotto> lottos;

        purchaseLotto();
        lottos = createLottos();
    }
}
