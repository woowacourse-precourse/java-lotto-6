package lotto;

import lotto.view.InputView;

public class LottoController {

    public void run() {
        LottoPurchaseMoney lottoPurchaseMoney = getLottoPurchaseMoney();
        int numberOfLottos = lottoPurchaseMoney.getNumberOfLottoAvailableForPurchase();
        Lottos userLottos = new Lottos(numberOfLottos);
    }

    private static LottoPurchaseMoney getLottoPurchaseMoney() {
        try {
            int inputMoney = InputView.readLottoPurchaseMoney();
            return new LottoPurchaseMoney(inputMoney);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoPurchaseMoney();
        }
    }
}
