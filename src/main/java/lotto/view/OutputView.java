package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.enums.Rank;

public class OutputView {
    public void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.printf("%d개를 구매했습니다.\n", lottoTickets.size());
        for (Lotto lotto : lottoTickets) {
            List<String> numbers = lotto.getNumbers().stream()
                    .map(String::valueOf).toList();
            System.out.print("[");
            System.out.print(String.join(", ", numbers));
            System.out.println("]");
        }
    }

    public void printTotalPrize(Map<Rank, Integer> result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.printf("3개 일치 (5,000원) - %d개\n", result.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", result.get(Rank.FOURTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", result.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", result.get(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", result.get(Rank.FIRST));
    }
}
