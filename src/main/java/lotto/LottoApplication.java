package lotto;

import lotto.controller.LotteryStore;
import lotto.domain.Money;
import lotto.dto.PurchasedLottosDto;
import lotto.view.ConsoleMessageView;
import lotto.view.MoneyInputView;
import lotto.view.PurchasedLottoOutputView;

public class LottoApplication {

    private static final long CURRENCY = 1000;

    Money money;
    LotteryStore lottoStore = new LotteryStore();

    public void run() {
        String money = getMoneyFromUserInput();
        storeMoneyOf(money);

        lottoStore.getLottoOrderUpTo((int)this.money.showCountConvertTo(CURRENCY));

        PurchasedLottosDto purchasedLottos = fetchPurchasedLottos();
        printFrom(purchasedLottos);


    }

    private String getMoneyFromUserInput() {
        ConsoleMessageView.printMoneyInputMessage();
        return MoneyInputView.input();
    }

    private void storeMoneyOf(String money) {
        this.money = Money.of(money);
    }

    private PurchasedLottosDto fetchPurchasedLottos() {
        return lottoStore.showPurchasedLottos();
    }

    private void printFrom(PurchasedLottosDto purchasedLottosDto) {
        int count = purchasedLottosDto.show()
                                     .size();
        PurchasedLottoOutputView.outputPurchasedCount(count);
        PurchasedLottoOutputView.outputPurchasedLottos(purchasedLottosDto.show());
    }

}
