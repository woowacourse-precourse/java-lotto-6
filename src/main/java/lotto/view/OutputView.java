package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public static final String LOTTO_TICKETS_COUNT_FORMAT = "%d개를 구매했습니다.";

    public static String lottoTicketsCountTemplate(int count) {
        return String.format(LOTTO_TICKETS_COUNT_FORMAT, count);
    }

    public static String lottoTicketsTemplate(List<Lotto> lottoTickets) {
        StringBuilder sb = new StringBuilder();
        lottoTickets.forEach(lotto -> {
            sb.append(lotto.toString());
            sb.append("\n");
        });
        return sb.toString();
    }
}
