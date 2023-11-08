package lotto.view;

import static lotto.view.constants.ViewMessage.LOTTO_PURCHASE_NOTICE_MESSAGE;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.constants.ViewMessage;

public class OutputView {
    public static void printMessage(final String message) {
        System.out.println(message);
    }

    public static void printMessage(final ViewMessage viewMessage) {
        System.out.println(viewMessage.getMessage());
    }

    public static void printMessage(final Lottos lottoTicket, final Buyer buyer) {
        printMessage(String.format(LOTTO_PURCHASE_NOTICE_MESSAGE.getMessage(), buyer.getPurchaseCount()));
        for (Lotto lotto : lottoTicket.getLottoTicket()) {
            printMessage(lotto);
        }
    }

    public static void printMessage(final Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

}
