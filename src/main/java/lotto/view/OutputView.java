package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.printf("%d개를 구매했습니다.\n", lottoTickets.size());
        for (Lotto lotto : lottoTickets) {
            List<String> numbers = lotto.getNumbers().stream()
                    .map(String::valueOf).toList();
            System.out.print("[");
            System.out.print(String.join(", ", numbers));
            System.out.println("]");
        }
    }
}
