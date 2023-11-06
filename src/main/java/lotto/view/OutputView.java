package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTickets;

public class OutputView {

    public void printPurchasedLottoTickets(LottoTickets lottoTickets) {
        System.out.println("\n" + lottoTickets.getLottoTickets().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets.getLottoTickets()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
