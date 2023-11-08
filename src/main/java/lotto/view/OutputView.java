package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {

    public void printLottoTicketCount(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다");
    }

    public void printLottoTickets(List<Lotto> lottos){
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbersByAsc());
        }
    }

}
