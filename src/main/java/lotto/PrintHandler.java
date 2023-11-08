package lotto;

import java.util.Collections;
import java.util.List;

public class PrintHandler {
    
    public static void printLottos(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
    
    
    public static void printResults(Result results) {
        System.out.println("당첨 통계");
        for(Score score : Score.values()) {
            int frequency = Collections.frequency(results.getScores(), score);
            System.out.println(score.getMessage() + " - " + frequency + "개");
        }
        System.out.println("총 수익률은 " + results.getProfitRate() + "%입니다.");
    }
    
}
