package lotto.view;

import lotto.model.LottoStatistics;

public class ResultOutputView {
    private static final String UINT_WORD = "개";
    private final LottoStatistics lottoStatistics;

    public ResultOutputView(LottoStatistics lottoStatistics) {
        this.lottoStatistics = lottoStatistics;
    }

    public void printWinningStatistics() {
        System.out.println(ResultMessage.RESULT.getMessage());
        System.out.println(ResultMessage.DIVIDING_LINE.getMessage());
        System.out.println(ResultMessage.THREE_NUMBERS.getMessage()
                + lottoStatistics.getThreeNumbersMatch()
                + UINT_WORD);
        System.out.println(ResultMessage.FOUR_NUMBERS.getMessage()
                + lottoStatistics.getFourNumbersMatch()
                + UINT_WORD);
        System.out.println(ResultMessage.FIVE_NUMBERS.getMessage()
                + lottoStatistics.getFiveNumbersMatch()
                + UINT_WORD);
        System.out.println(ResultMessage.FIVE_NUMBERS_AND_BONUS_NUMBER.getMessage()
                + lottoStatistics.getFiveNumbersAndBonusNumberMatch()
                + UINT_WORD);
        System.out.println(ResultMessage.SIX_NUMBERS.getMessage()
                + lottoStatistics.getSixNumbersMatch()
                + UINT_WORD);
    }

    public void printTotalProfit(double totalProfit) {
        System.out.print(String.format(String.valueOf(ResultMessage.TOTAL_PROFIT), totalProfit));
    }
}
