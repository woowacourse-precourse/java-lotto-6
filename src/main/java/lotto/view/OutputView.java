package lotto.view;

import lotto.domain.Lotto;
import static lotto.common.InfoMessage.*;

import java.util.List;

public class OutputView {

    public void showLotteryTickets(List<Lotto> lotteryTickets ) {
        System.out.printf(PURCHASE_QUANTITY.getMessage(), lotteryTickets.size());
        for (Lotto lotteryTicket : lotteryTickets) {
            System.out.println(lotteryTicket);
        }
    }
}
