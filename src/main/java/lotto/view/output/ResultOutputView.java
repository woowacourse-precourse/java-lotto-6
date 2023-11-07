package lotto.view.output;

import lotto.model.LottoStatistics;

public class ResultOutputView {
    public void printWinningStatistics(LottoStatistics lottoStatistics) {
        printStartWinningStatistics();
        System.out.println(String.format(ResultMessage.THREE_NUMBERS.getMessage(), lottoStatistics.getThreeNumbersMatch()));
        System.out.println(String.format(ResultMessage.FOUR_NUMBERS.getMessage(), lottoStatistics.getFourNumbersMatch()));
        System.out.println(String.format(ResultMessage.FIVE_NUMBERS.getMessage(), lottoStatistics.getFiveNumbersMatch()));
        System.out.println(String.format(ResultMessage.FIVE_NUMBERS_AND_BONUS_NUMBER.getMessage(), lottoStatistics.getFiveNumbersAndBonusNumberMatch()));
        System.out.println(String.format(ResultMessage.SIX_NUMBERS.getMessage(), lottoStatistics.getSixNumbersMatch()));
    }

    private void printStartWinningStatistics() {
        System.out.println(ResultMessage.RESULT.getMessage());
        System.out.println(ResultMessage.DIVIDING_LINE.getMessage());
    }

    public void printTotalProfit(double totalProfit) {
        System.out.print(String.format(ResultMessage.TOTAL_PROFIT.getMessage(), totalProfit));
    }
}
