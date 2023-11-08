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

    public void printResult(List<Integer> counts) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + counts.get(0));
        System.out.println("4개 일치 (50,000원) - " + counts.get(1));
        System.out.println("5개 일치 (1,500,000원) - " + counts.get(2));
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + counts.get(3));
        System.out.println("6개 일치 (2,000,000,000원) - " + counts.get(4));
    }
}
