package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.\n";

    public void print(List<Lotto> lottoTickets) {
        printCountOf(lottoTickets);
        lottoTickets.forEach(System.out::println);
    }

    private void printCountOf(List<Lotto> lottoTickets) {
        System.out.printf(PURCHASE_MESSAGE, lottoTickets.size());
    }
}