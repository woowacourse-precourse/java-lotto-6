package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.WinningPrize;

import java.util.List;

public class OutputView {
    public static void showCount(int count) {
        System.out.println();
        System.out.println(String.valueOf(count)+"개를 구매했습니다.");
    }
    public static void showLottoTickets(List<Lotto> tickets) {
        for(Lotto ticket : tickets){
            System.out.println(ticket.toString());
        }
    }

    public static void showLottoResult(List<Integer> result, String profit) {
        String[] priceArray = {"3개 일치 (5,000원)","4개 일치 (50,000원)","5개 일치 (1,500,000원)","5개 일치, 보너스 볼 일치 (30,000,000원)","6개 일치 (2,000,000,000원)"};

        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        for(int i=0; i<5; i++){
            System.out.println(priceArray[i] + " - " + result.get(i) + "개");
        }

        System.out.println("총 수익률은 " + profit + "%입니다.");
    }
}
