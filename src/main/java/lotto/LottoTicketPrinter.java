package lotto;

import lotto.Lotto;

import java.util.List;

public class LottoTicketPrinter {

    public static void printTickets(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
