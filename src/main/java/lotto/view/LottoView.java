package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class LottoView {


    public void inputMoneyView() {
        System.out.println("구입 금액을 입력해 주세요.");
    }

    public void outputBuyLottoTicketsView(int ticketCount) {
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    public void outputLottoTicketNumbersView(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets)
            System.out.println(lotto.getNumbers());
    }

}
