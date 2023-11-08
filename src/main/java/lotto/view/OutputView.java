package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void printResult(LottoResult lottoResult, double profit) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoResult.getThree() + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoResult.getFour() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoResult.getFive() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + lottoResult.getFiveB() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoResult.getSix() + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.", profit);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {

            List<Integer> numbers = lotto.getNumbers();
            ArrayList<Integer> newN = new ArrayList<>(numbers);

            Collections.sort(newN);
            System.out.println(newN.toString());
        }
    }
}
