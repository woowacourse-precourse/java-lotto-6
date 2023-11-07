package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoEnum;
import lotto.domain.LottoResult;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

    // 발행된 로또 번호 출력 로직 작성 필요
    public class OutputView {
        public static void printTickets(List<Lotto> tickets) {
            System.out.println(tickets.size() + "개를 구매했습니다.");
            for (Lotto ticket : tickets) {
                System.out.println(ticket.getNumbers());
            }
        }

        public static void printResult(LottoResult result, int purchaseAmount) {
            System.out.println("당첨 통계");
            System.out.println("---------");
            Arrays.stream(LottoEnum.LottoRank.values())
                    .filter(rank -> rank != LottoEnum.LottoRank.MISS)
                    .sorted(Comparator.reverseOrder())
                    .forEach(rank -> System.out.println(rank + " - " + result.getCount(rank) + "개"));
            System.out.println("총 수익률은 " + result.calculateEarningsRate(purchaseAmount)*100 + "%입니다.");
        }
    }

