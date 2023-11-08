package lotto.view;

import lotto.constant.LottoConstant;
import lotto.constant.LottoCount;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printRandomSixNumbers(List<List<Integer>> randomSixNumbers) {
        System.out.println(String.format(LottoConstant.OUTPUT_PURCHASE_AMOUNT_MESSAGE, randomSixNumbers.size()));
        for(List<Integer> randomSixNumber : randomSixNumbers){
            System.out.println(randomSixNumber);
        }
    }

    public void printWinningStatistics(HashMap<Integer, Integer> winningResult) {
        System.out.println(LottoConstant.OUTPUT_WINNING_STATISTICS);
        System.out.println(LottoConstant.OUTPUT_LINE);
        for (LottoCount lottoCount : LottoCount.values()) {
            int count = winningResult.getOrDefault(lottoCount.getGrade(), 0);
            System.out.println(lottoCount.getMessage(count));
        }
    }

    public void printProfitMargin(double profitMargin) {
        System.out.println(String.format(LottoConstant.PROFIT_MARGIN_MESSAGE, profitMargin));
    }
}
