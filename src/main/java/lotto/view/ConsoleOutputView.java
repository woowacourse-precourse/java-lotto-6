package lotto.view;

import java.util.List;

public class ConsoleOutputView {

    public void outputErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void outputBuyLottoTickets(List<List<Integer>> lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
        System.out.println();
    }
}
