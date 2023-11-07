package lotto.view;

import lotto.model.LottoTicketEntity;

import java.util.List;

public class OutputView {
    public static void printLottoTickets(List<LottoTicketEntity> lottoTickets) {
        for (LottoTicketEntity lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getLottoNumbers());
        }
        System.out.println();
    }
}
