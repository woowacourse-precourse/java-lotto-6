package lotto.view;

import lotto.view.message.view.ResultMessage;

import java.util.Map;

public class OutputView {
    public void displayResult(Map<String, Integer> statisticsMatchesCounts, float profitPercent){
        StringBuilder sb = new StringBuilder();
        sb.append(ResultMessage.START_TO_SHOW_STATISTICS.getMessage());
        sb.append(String.format(ResultMessage.MATCHES_3_NUMBERS.getMessage(), statisticsMatchesCounts.get("matchesThree")));
        sb.append(String.format(ResultMessage.MATCHES_4_NUMBERS.getMessage(),statisticsMatchesCounts.get("matchesFour")));
        sb.append(String.format(ResultMessage.MATCHES_5_NUMBERS.getMessage(),statisticsMatchesCounts.get("matchesFive")));
        sb.append(String.format(ResultMessage.MATCHES_5_NUMBERS_AND_BONUS.getMessage(),statisticsMatchesCounts.get("matchesFiveAndBonus")));
        sb.append(String.format(ResultMessage.MATCHES_6_NUMBERS.getMessage(),statisticsMatchesCounts.get("matchesSix")));
        sb.append(String.format(ResultMessage.PROFIT_PERCENT.getMessage(),profitPercent));

        System.out.print(sb);
    }
}
