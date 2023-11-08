package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public static final String PURCHASE = "%s개를 구매했습니다%n";

    public void outputLottoTickets(List<Lotto> lottoSets) {
        int count = lottoSets.size();
        System.out.printf(PURCHASE, count);
        for (Lotto lotto : lottoSets) {
            System.out.println(lotto.getNumbers());
        }
    }

}
