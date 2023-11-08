package lotto.manager;

import lotto.model.Lottos;

import java.util.Arrays;
import java.util.List;

public class OutputManager {

    private final List<String> rankMessage = Arrays.asList(
            "6개 일치 (2,000,000,000원)",
            "5개 일치, 보너스 볼 일치 (30,000,000원)",
            "5개 일치 (1,500,000원)",
            "4개 일치 (50,000원)",
            "3개 일치 (5,000원)"
    );

    public void printLottos(Lottos lottos) {
        System.out.println("\n" + lottos.getLottos().size() + "개를 구매했습니다.");
        for (int i = 0; i < lottos.getLottos().size(); i++) {
            System.out.println(lottos.getLottos().get(i).getNumbers().toString());
        }
    }

    public void printResult(List<Integer> ranks, double returnRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (int i = rankMessage.size() - 1; i >= 0; i--) {
            System.out.println(rankMessage.get(i) + " - " + ranks.get(i) + "개");
        }
        System.out.println("총 수익률은 " + Math.round(returnRate * 100) / 100.0 + "%입니다.");
    }


}
