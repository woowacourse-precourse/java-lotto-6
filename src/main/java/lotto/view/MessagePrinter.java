package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;

import java.util.List;

import static lotto.constant.MessageConstant.BUYING_AMOUNT_MESSAGE;
import static lotto.constant.MessageConstant.BUYING_PRICE_MESSAGE;

public class MessagePrinter {

    public void printBuyingPriceMessage() {
        System.out.println(BUYING_PRICE_MESSAGE);
    }

    public void printBuyingAmountMessage(final int buyingAmount) {
        System.out.println(buyingAmount + BUYING_AMOUNT_MESSAGE);
    }

    public void printLottoNumbers(final LottoGame lottoGame) {
        List<Lotto> lottos = lottoGame.getLottos();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        }
    }
}
