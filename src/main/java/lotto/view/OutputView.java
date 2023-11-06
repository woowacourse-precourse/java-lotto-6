package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public void printAllTickets(List<Lotto> tickets){
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (int i = 0; i < tickets.size() ; i++) {
            System.out.println(tickets.get(i).toString());
        }
    }
    public void printRankResult(int[] rankCount, double profitability){
        System.out.println("3개 일치 (5,000원) - " + rankCount[0]+"개");
        System.out.println("4개 일치 (50,000원) - " + rankCount[1]+"개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCount[2]+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount[3]+"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCount[4]+"개");

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("총 수익률은 " + df.format(profitability) + "%입니다.");
    }
}
