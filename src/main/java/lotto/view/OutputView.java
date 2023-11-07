package lotto.view;
import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void displayLottoTickets(List<Lotto> lottoTickets) {
        int ticketCount = lottoTickets.size();
        System.out.println("\n" + ticketCount + "개를 구매했습니다.");
        for (Lotto ticket : lottoTickets) {
            System.out.println(ticket.getNumbers());
        }
    }
}

