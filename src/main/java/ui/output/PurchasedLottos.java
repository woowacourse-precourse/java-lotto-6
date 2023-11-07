package ui.output;

import domain.LottoTicket.LottoTicket;
import lotto.Lotto;

import java.util.List;

public class PurchasedLottos {
    public static void printPurchasedLottos(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (LottoTicket ticket : lottoTickets) {
            for (Lotto lotto : ticket.getLottoNumbers()) {
                System.out.println(lotto.getNumbers());
            }
        }
    }
}
