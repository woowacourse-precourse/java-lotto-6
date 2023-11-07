package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    private static final String LOTTO_PURCHASE_FORMAT = "\n%d개를 구매했습니다.";

    // 기본 생성자가 만들어지는 것을 막는다. (인스턴스화 방지용).
    private OutputView() {
        throw new AssertionError();
    }

    public static void printLottoTickets(final List<Lotto> lottoTickets) {
        System.out.printf((LOTTO_PURCHASE_FORMAT) + "%n", lottoTickets.size());
        for (final Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }
}
