package lotto;

import lotto.interactor.Buyer;
import lotto.interactor.LottoMachine;
import lotto.prize.*;

import java.util.List;

public class LottoManager {
    public void run() {
        Buyer buyer = new Buyer();
        LottoMachine lottoMachine = new LottoMachine();
        Lottos lottos = lottoMachine.generateLottos(buyer.getTickets());
        Jackpot jackpot = new Jackpot();

        List<MatchResult> matchResults = lottos.calculateResults(jackpot);

        ProfitCalculator profitCalculator = new ProfitCalculator();
        double profitRate = profitCalculator.calculateProfit(matchResults, buyer.getTickets() * LottoMachine.TICKET_PRICE);

        printResults(matchResults, profitRate);
    }
    public void printResults(List<MatchResult> matchResults, double profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue; // NONE 등수는 출력하지 않음
            }

            long count = matchResults.stream()
                    .filter(result -> result.getRank() == rank)
                    .count();

            System.out.printf("%s - %d개%n", rank.getDescription(), count);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
