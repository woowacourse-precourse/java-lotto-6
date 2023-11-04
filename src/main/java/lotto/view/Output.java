package lotto.view;

import static lotto.constant.OutputMessage.PURCHASE_COUNT_DEFAULT_MESSAGE;
import static lotto.constant.OutputMessage.REQUEST_PURCHASE_PRICE_MESSAGE;
import static lotto.constant.OutputMessage.REQUEST_WINNING_NUMBER_MESSAGE;

import lotto.domain.Lottos;
import lotto.domain.Player;
import lotto.domain.PurchasePrice;

public class Output {


    public static void errorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void requestPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE_MESSAGE);
    }

    public void purchaseCount(PurchasePrice purchasePrice) {
        System.out.println(purchasePrice.calculatePurchaseCount() + PURCHASE_COUNT_DEFAULT_MESSAGE);
    }

    public void requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBER_MESSAGE);
    }

    public void purchaseLotts(Player player) {
        Lottos lottos = player.getLottos();
        lottos.getLottos()
                .forEach((lotto -> System.out.println(lotto.getNumbers())));
        System.out.println();
    }
}
