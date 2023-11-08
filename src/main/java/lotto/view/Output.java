package lotto.view;

import lotto.model.LottoTicket;

import java.util.List;

public class Output {

    public void printLottoTickets(List<List<Integer>> lottoTickets) {
        System.out.println(String.format("%d개를 구매했습니다.",lottoTickets.size()));
        for (List<Integer> lotto: lottoTickets) {
            System.out.println(lotto);
        }
    }

}
