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

    public static void bonusNumbersMessagePrint() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void lottoResultMessagePrint(List<Integer> lottoResult) {
        System.out.printf("3개 일치 (5,000원) - %d개", lottoResult.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개", lottoResult.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개", lottoResult.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", lottoResult.get(3));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개", lottoResult.get(4));
    }
}
