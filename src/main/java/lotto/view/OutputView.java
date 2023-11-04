package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;

import java.util.List;

public class OutputView {

    public void displayLotto(LottoCount lottoCount, List<Lotto> lottoTickets) {
        System.out.println();
        System.out.println(lottoCount.getLottoCount() + "개를 구매했습니다.");

        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }
}
