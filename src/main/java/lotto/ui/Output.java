package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public class Output {
    public void notifyLottoCount(List<Lotto> lottoTickets) {
        System.out.printf("%d개를 구매했습니다.", lottoTickets.size());
    }
}
