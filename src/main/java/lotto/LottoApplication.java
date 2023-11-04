package lotto;

import lotto.controller.LotteryStore;
import lotto.domain.Money;
import lotto.dto.PurchasedLottosDto;
import lotto.view.InputMessageView;
import lotto.view.MoneyInputView;

public class LottoApplication {

    private static final long CURRENCY = 1000;

    Money money;
    LotteryStore lottoStore;

    public void run() {
        String money = getMoneyFromUserInput();
        storeMoneyOf(money);

        lottoStore.getLottoOrderUpTo((int)this.money.showCountConvertTo(CURRENCY));
        PurchasedLottosDto purchasedLottos = fetchPurchasedLottos();

    }

    private String getMoneyFromUserInput() {
        InputMessageView.printMoneyInputMessage();
        return MoneyInputView.input();
    }

    private void storeMoneyOf(String money) {
        this.money = Money.of(money);
    }

    private PurchasedLottosDto fetchPurchasedLottos() {
        return lottoStore.showPurchasedLottos();
    }

}
