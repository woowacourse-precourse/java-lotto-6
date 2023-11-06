package lotto.view;

import lotto.domain.Buyer;
import lotto.view.contants.OutputMessage;

public class OutputView {

    public static void purchaseLottos(Buyer buyer) {
        System.out.println(String.format(OutputMessage.PURCHASE_RESULT.getValue(), buyer.lottoCount()));
        System.out.println(buyer);
    }
}
