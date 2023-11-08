package ui;

import lotto.MatchState;

import java.text.DecimalFormat;
import java.util.Map;

public class Output {
    public void printResult(Map<MatchState, Integer> totalMatchCounts) {
        for(MatchState matchState : MatchState.values()) {
            if (matchState.equals(MatchState.MATCH_COUNT_BONUS)) {
                System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + totalMatchCounts.getOrDefault(matchState, 0) + "개");
                continue;
            }
            System.out.println(matchState.getMatchCount() + "개 일치 " +
                    "(" + convertIntegerToPrize(matchState.getPrize()) + ") - " + totalMatchCounts.getOrDefault(matchState, 0) + "개");
        }
    }

    public void printRateOfReturn(float rateOfReturn) {
        System.out.printf("총 수익률은 %.2f%%입니다.%n", rateOfReturn);
    }

    private String convertIntegerToPrize(int prize) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(prize) + "원";
    }
}
