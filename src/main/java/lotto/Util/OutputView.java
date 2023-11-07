package lotto.Util;

import lotto.Domain.LottoTickets;

public class OutputView {
    public static void printLottoTickets(LottoTickets lottoTickets){
        lottoTickets.getLottoTickets().forEach(System.out::println);
        System.out.println();
    }

}
