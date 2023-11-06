package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Rank;

public class OutputMessage {
    private OutputMessage() {
    }

    public static void purchasedLotto(int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
    }

    public static void showLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public static void showLottoResult(Map<Rank, Integer> resultRank) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", resultRank.get(Rank.FIFTH));
        System.out.printf("4개 일치 (50,000원) - %d개\n", resultRank.get(Rank.FORTH));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", resultRank.get(Rank.THIRD));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", resultRank.get(Rank.SECOND));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개", resultRank.get(Rank.FIRST));
    }
}
