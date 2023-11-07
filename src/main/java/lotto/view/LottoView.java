package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class LottoView {


    public void inputMoneyView() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void outputBuyLottoTicketsView(int ticketCount) {
        System.out.println();
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    public void outputLottoTicketNumbersView(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets)
            System.out.println(lotto.getNumbers());
    }

    public void inputWinnerNumbersView() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }

    public void inputBonusNumberView() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public void outputWinningStatisticsView() {
        System.out.println("\n당첨 통계\n---");
    }

    public void outputWinningDescription(String t) {
        System.out.println(t);
    }


    public void outputRevenueView(double revenue) {
        System.out.println("총 수익률은 " + String.format("%.1f", revenue) + "%입니다.");
    }

}
