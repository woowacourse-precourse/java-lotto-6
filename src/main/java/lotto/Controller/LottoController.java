package lotto.Controller;

import lotto.View.InputView;
import lotto.View.OutputView;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;

    public void GameProgress() {
        int lottoCount = Integer.parseInt(InputView.InputBuyCost());
        OutputView.OutputLottoPurchased(lottoCount);

    }
}
