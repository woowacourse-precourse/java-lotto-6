package lotto.view;

import java.util.List;

public class RateView {
    public void printResultStart() {
        System.out.println("당첨 통계\n---");
    }

    public void printPrize(List<Integer> resultCount, List<String> resultHit, List<String> resultPrize) {
        for (int i = 0; i < resultCount.size(); i++) {
            System.out.println(resultHit.get(i) + resultPrize.get(i) + " - " + resultCount.get(i) + "개");
        }
    }

    public void printRate(int returnRate) {
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }

}
