package lotto.view.outputview;

import java.util.List;
import lotto.domain.lotto.Lotto;


public class LottoTicketOutputView {

    public static void printLottoTickets(List<Lotto> tickets) {
        tickets.stream()
                .map(Lotto::getLotto)
                .forEach(lotto -> printLottoNumbers(lotto));
    }

    private static void printLottoNumbers(List<Integer> lotto) {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        for (int idx = 0; idx < lotto.size(); idx++) {
            sb.append(lotto.get(idx));
            if (idx < lotto.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");

        System.out.println(sb);
    }
}
