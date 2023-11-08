package view;


import domain.Ranking;
import java.util.HashMap;
import java.util.List;
import lotto.Lotto;

public class OutputView {

    public static final String EMPTY_ERROR_MESSAGE = "구매금액을 입력해주세요";


    public static void printLottoCount(int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printLotties(List<Lotto> lotties) {
        lotties.stream().forEach(lotto -> {
            List<Integer> numbers = lotto.getNumbers();
            System.out.println(numbers);
        });
        System.out.println();
    }

    public static void result(Ranking ranking,
                              HashMap<Ranking, Integer> totalRanking,
                              float rateOfReturn) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (Ranking rank : ranking.values()) {
            if (rank == Ranking.MISS) {
                continue;
            }
            //System.out.println(totalRanking);
            System.out.println(rank.getWinningMessage() + totalRanking.get(rank) + "개");
        }
        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);

    }


}
