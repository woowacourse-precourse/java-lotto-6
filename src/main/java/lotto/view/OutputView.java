package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import static lotto.util.GameMessage.*;

public class OutputView {

    public static void printPurchaseAmount(int purchaseAmount) {
        System.out.println(purchaseAmount + PURCHASE_MESSAGE.getMessage());
    }

    public static void printLottoNumbers(Lottos lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
