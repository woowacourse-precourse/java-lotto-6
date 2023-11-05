package View;

import lotto.Lotto;
import lotto.Result;

import java.util.List;

public class Output {
    public static void printCreatedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for(Lotto lotto: lottos) {
            System.out.println(lotto);
        }
        System.out.println();
    }

//    public static void printWinningStatistic(List<Result> results) {
//        System.out.println("당첨 통계");
//        System.out.println("---");
//        System.out.printf("3개 일치 (5,000원) - %d개%n", (int)rankingCounter[5]);
//        System.out.printf("4개 일치 (50,000원) - %d개%n", (int)rankingCounter[4]);
//        System.out.printf("5개 일치 (1,500,000원) - %d개%n", (int)rankingCounter[3]);
//        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", (int)rankingCounter[2]);
//        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", (int)rankingCounter[1]);
//    }

}
