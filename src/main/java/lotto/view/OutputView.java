package lotto.view;

import lotto.constant.LottoCount;
import lotto.constant.OutputMessage;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printRandomSixNumbers(List<List<Integer>> randomSixNumbers) {
        System.out.println(OutputMessage.OUTPUT_PURCHASE_AMOUNT_MESSAGE.getMessage(randomSixNumbers.size()));
        for(List<Integer> randomSixNumber : randomSixNumbers){
            System.out.println(randomSixNumber);
        }
    }

    public void printWinningStatistics(HashMap<Integer, Integer> winningResult) {
        System.out.println(OutputMessage.OUTPUT_WINNING_STATISTICS.getMessage());
        System.out.println(OutputMessage.OUTPUT_LINE.getMessage());
        for (LottoCount lottoCount : LottoCount.values()) {
            int count = winningResult.getOrDefault(lottoCount.getGrade(), 0);
            System.out.println(lottoCount.getMessage(count));
        }
    }
}
