package ui;

import lotto.MatchState;

import java.text.DecimalFormat;

public class Output {
    public void printResult(MatchState matchState, int totalNumberOfMatch) {
        if (matchState.equals(MatchState.MATCH_COUNT_BONUS))
        {
            System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + totalNumberOfMatch);
            return;
        }
        System.out.println(matchState.getMatchCount() + "개 일치 " +
                "(" + convertIntegerToPrize(matchState.getPrize()) + ") - " + totalNumberOfMatch);
    }

    private String convertIntegerToPrize(int prize) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(prize) + "원";
    }
}
