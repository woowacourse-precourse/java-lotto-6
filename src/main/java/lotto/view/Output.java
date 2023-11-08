package lotto.view;

import java.util.List;

public class Output {

    public void printLottoTickets(List<List<Integer>> lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }
}
