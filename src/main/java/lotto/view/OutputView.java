package lotto.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {
    public void printLottoTickets(List<Lotto> lottoTickets) {
        StringBuilder sb = new StringBuilder("\n");
        sb.append(lottoTickets.size()).append("개를 구매했습니다.").append("\n");
        for (Lotto lotto : lottoTickets) {
            sb.append(lotto.getLottoNumbersToPrint()).append("\n");
        }
        System.out.println(sb);
    }
}
