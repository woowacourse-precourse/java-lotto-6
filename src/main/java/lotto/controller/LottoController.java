package lotto.controller;

import lotto.domain.Lottos;
import lotto.view.OutputView;

public class LottoController {
    public Lottos createLottos(final int count) {
        return new Lottos(count);
    }

    public static void printLottos(Lottos lottos) {
        OutputView.printLottos(lottos);
    }
}
