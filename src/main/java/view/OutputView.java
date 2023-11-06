package view;

import dto.Lotto;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void showScore(Map<Integer, Integer> lottoScore, int hasFiveAndbonusNumber) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + lottoScore.get(3) + "개");
        System.out.println("4개 일치 (50,000원) - " + lottoScore.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + lottoScore.get(5) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + hasFiveAndbonusNumber + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + lottoScore.get(6) + "개");
    }

}
