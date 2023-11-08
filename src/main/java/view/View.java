package view;

import java.util.List;
import model.Lotto;

public class View {
    public static void moneyMessagePrint() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void lottoTicketsCountPrint(int lottoTicketsCount) {
        System.out.println();
        System.out.println(lottoTicketsCount + "개를 구매했습니다.");
    }

    public static void lottoTicketsPrint(List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto);
        }
    }

    public static void winningNumbersMessagePrint() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }
}
