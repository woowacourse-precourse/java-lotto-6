package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;

public class OutputView {

    public static void showResult(Map<String, Integer> result, float rate) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + result.getOrDefault("3", 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + result.getOrDefault("4", 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result.getOrDefault("5", 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result.getOrDefault("5+", 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result.getOrDefault("6", 0) + "개");
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }

    public static void showBundle(List<Lotto> bundle) {
        System.out.println(bundle.size() + "개를 구매했습니다.");
        for (Lotto lotto : bundle) {
            System.out.println(lotto.toString());
        }
    }
}