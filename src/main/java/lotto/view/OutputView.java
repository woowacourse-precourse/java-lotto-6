package lotto.view;

import java.util.EnumMap;
import java.util.List;
import lotto.model.domain.Lotto;
import lotto.model.domain.Rank;

public class OutputView {

    private static final String PURCHASE_INFORMATION = "개를 구매했습니다.";
    private static final String RANK_INFORMATION = "%d개 일치 (%,d원) - %d개 %n";
    private static final String SECOND_RANK_INFORMATION = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개 %n";
    private static final String RATE_OF_RETURN = "총 수익률은 %,.1f%%입니다.";

    public void lottoTickets(List<Lotto> lottos) {

        System.out.printf("%d%s %n", lottos.size(), PURCHASE_INFORMATION);

        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i).getNumbers());
        }
    }

    public void winningRecords(EnumMap<Rank, Integer> winningStatics) {
        Rank[] ranks = Rank.values();

        for (Rank rank : ranks) {
            int matchingNum = rank.getMatchingNum();
            int prize = rank.getPrize();
            int count = winningStatics.get(rank);

            if (rank != Rank.SECOND_RANK) {
                System.out.printf(RANK_INFORMATION, matchingNum, prize, count);
            }
            System.out.printf(SECOND_RANK_INFORMATION, matchingNum, prize, count);
        }
    }

    public void prizesSummary(float rateOfReturn) {
        System.out.printf(RATE_OF_RETURN, rateOfReturn);
    }
}
