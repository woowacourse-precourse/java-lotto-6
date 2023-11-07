package lotto;

import java.util.List;

public class Print {
    protected void printPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    protected void printTicketCount(int ticketCount) {
        System.out.println(ticketCount + "개를 구매했습니다.");
    }

    protected void printInputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    protected void printInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    protected void printLottoTickets(List<List<Integer>> lottoTickets) {
        for (List<Integer> ticket : lottoTickets) {
            System.out.println(ticket);
        }
    }
}
