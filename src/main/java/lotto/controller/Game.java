package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Game {
    private static final int THOUSAND_UNIT = 1000;

    public void start() {
        int purchaseQuantity = InputView.askPurchaseAmount() / THOUSAND_UNIT;
        List<Lotto> lottos = issueLottos(purchaseQuantity);
        OutputView.printPurchaseResult(lottos);

    }

    private List<Lotto> issueLottos(int purchaseQuantity) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            Lotto lotto = new Lotto(Lotto.issueLotto());
            lottos.add(lotto);
        }
        return lottos;
    }
}
