package lotto.view;

import lotto.domain.Compare;
import lotto.domain.Score;

public class OutputLottoResultsView {
    private static final int ZERO = 0;
    private static final String OUTPUT_MESSAGE = "당첨 통계\n---";
    private static final String RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    public static void printResults(Compare scoreResult){
        System.out.println(OUTPUT_MESSAGE);
        for(Score score : Score.values()) {
            printBonus(scoreResult, score);
            printNoNull(scoreResult, score);
        }
    }

    private static void printBonus(Compare scoreResult, Score score) {
        if(score == Score.SECOND) {
            System.out.printf(BONUS_MESSAGE, score.getSameNumber(), String.format("%,d", score.getMoney()), scoreResult.getScoreResult(score));
            System.out.println();
        }
    }

    private static void printNoNull(Compare scoreResult, Score score) {
        if(score.getSameNumber() != ZERO && score != Score.SECOND) {
            System.out.printf(RESULT_MESSAGE, score.getSameNumber(), String.format("%,d", score.getMoney()), scoreResult.getScoreResult(score));
            System.out.println();
        }
    }
}
