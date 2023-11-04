package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.ui.OutputView;

public class LottoContentController {
    private final OutputView output;

    public LottoContentController() {
        this.output = new OutputView();
    }

    public void showLottosResult(List<Lotto> lottos) {
        output.showLottosNumber(lottos);
    }
}
