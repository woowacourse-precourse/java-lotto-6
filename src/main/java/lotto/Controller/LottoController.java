package lotto.Controller;

import lotto.model.LottoPurchase;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private static int lottoCount;

    public static void start() {

    }

    private static void purchaseLotto() {
        OutputView.printPurchasePrice();
        LottoPurchase lottoPurchase = new LottoPurchase(InputView.readLine());
        lottoCount = lottoPurchase.getLottoCount();
        OutputView.printPurchaseMessage(lottoCount);
    }
}
