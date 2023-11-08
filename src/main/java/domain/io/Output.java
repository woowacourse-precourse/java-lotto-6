package domain.io;

import domain.LottoTicket;
import domain.result.TotalWinningResult;
import domain.result.WinningResult;

import java.util.ArrayList;
import java.util.Map;

public class Output {
    public static final String BUY_MSG = "개를 구매했습니다.";
    public static final String RESULT_MSG = "당첨 통계";

    public void printBuy(ArrayList<LottoTicket> lottoTickets) {
        System.out.println();
        System.out.println(lottoTickets.size() + BUY_MSG);

        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
        System.out.println();
    }

    public Integer printResult(TotalWinningResult totalWinningResult) {
        int totalReward = 0;
        System.out.println();
        System.out.println(RESULT_MSG);
        System.out.println("---");

        for (Map.Entry<WinningResult, Integer> entry : totalWinningResult.entrySet()) {
            if (entry.getKey() != WinningResult.LOSE) {
                WinningResult result = entry.getKey();
                int count = entry.getValue();
                int reward = result.getReward();
                if (reward == 30000000) {
                    System.out.printf("%d개 일치, 보너스 볼 일치 (%,d원) - %d개%n", result.getMatchCount(), reward, count);
                }
                else{
                    System.out.printf("%d개 일치 (%,d원) - %d개%n", result.getMatchCount(), reward, count);
                }
                totalReward += reward * count;
            }
        }
        return totalReward;
    }

    public void printRate(int inputCost, int outputCost) {
        System.out.printf("총 수익률은 %.1f%%입니다.", ((double)outputCost/inputCost) * 100);
    }
}
