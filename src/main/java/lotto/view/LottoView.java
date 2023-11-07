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

    public void inputWinnerNumbersView() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void inputBonusNumberView() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

}
