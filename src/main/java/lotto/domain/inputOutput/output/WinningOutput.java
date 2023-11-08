package lotto.domain.inputOutput.output;

import java.util.HashMap;

public class WinningOutput {
    public void displayWinningStatistics(HashMap<Integer, Integer> ranksHashMap) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + ranksHashMap.get(5) + "개");
        System.out.println("4개 일치 (50,000원) - " + ranksHashMap.get(4) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + ranksHashMap.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ranksHashMap.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ranksHashMap.get(1) + "개");
    }

    public void displayRateOfReturn(Double lottoRateOfReturn) {
        System.out.println("총 수익률은 "+String.format("%.1f",lottoRateOfReturn)+"%입니다.");
    }
}
