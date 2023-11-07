package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    public static void showLottoTickets(List<Lotto> lottoTickets) {
        System.out.println();
        System.out.println(String.format("%d개를 구매했습니다.", lottoTickets.size()));
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getNumbers());
        }
    }
}
