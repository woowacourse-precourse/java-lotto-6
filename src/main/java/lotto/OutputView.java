package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printNumberOfLotto(int numberOfLotto){
        String format=String.format("%d개를 구입하였습니다.", numberOfLotto);
        System.out.println(format);
    }

    public static void printLottoTicketNumbers(Lotto lottoTicket){
        System.out.println(lottoTicket.getNumbers());
    }

    public static void printResults(EnumMap<Rank, Integer> rankCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (Map.Entry<Rank, Integer> entry : rankCounts.entrySet()) {
            Rank rank=entry.getKey();
            if (rank == Rank.NOTHING) {
                continue;
            }
            int count = entry.getValue();

            if (rank.getMatchBonusCount()==1) {
                System.out.println(rank.getMatchWinningCount() + "개 일치, 보너스 볼 일치 (" + rank.getPrizeMoney() + "원) - " + count + "개");
            }
            if(rank.getMatchBonusCount()!=1){
                System.out.println(rank.getMatchWinningCount() + "개 일치(" + rank.getPrizeMoney() + "원) - " + count + "개");
            }

        }
    }

    public static void printEarningPercent(int totalPrizeMoney, int purchaseAmount) {
        System.out.println("총 수익률은 "+Math.round(totalPrizeMoney/(double)purchaseAmount*100*100)/100.00+"%입니다.");
    }
}
