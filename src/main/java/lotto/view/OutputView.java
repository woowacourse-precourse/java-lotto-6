package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoBundle;
import lotto.domain.Rank;

public class OutputView {

    /**
     * 당첨 통계를 출력한다.
     *
     * @param result : 결과
     * @param rate   : 수익률
     */
    public static void showResult(Map<Rank, Integer> result, double rate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            showRankResult(result, rank);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }

    /**
     * 당첨 등급별로 결과를 출력한다.
     *
     * @param result : 결과
     * @param rank   : 당첨 등급
     */
    private static void showRankResult(Map<Rank, Integer> result, Rank rank) {
        if (rank.getCount() == 0) {
            return;
        }
        if (rank.equals(Rank.SECOND)) {
            System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n",
                    rank.getCount(), rank.getText(), result.getOrDefault(rank, 0));
            return;
        }
        System.out.printf("%d개 일치 (%s원) - %d개\n", rank.getCount(), rank.getText(),
                result.getOrDefault(rank, 0));
    }

    /**
     * 구매한 로또의 개수를 출력한다.
     *
     * @param lottoBundle : 로또 묶음
     */
    public static void showBundle(LottoBundle lottoBundle) {
        List<Lotto> bundle = lottoBundle.getBundle();

        System.out.println(bundle.size() + "개를 구매했습니다.");
        for (Lotto lotto : bundle) {
            System.out.println(lotto.toString());
        }
    }
}