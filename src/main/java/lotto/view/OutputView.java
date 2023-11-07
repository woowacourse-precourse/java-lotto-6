package lotto.view;

import static lotto.constant.OutputConstant.NEW_LINE;
import static lotto.constant.OutputConstant.PER;
import static lotto.constant.OutputConstant.PERCENT;
import static lotto.constant.OutputConstant.PROFITABILITY_FORMAT;
import static lotto.constant.OutputConstant.PROFITABILITY_MESSAGE;
import static lotto.constant.OutputConstant.PURCHASE_MESSAGE;
import static lotto.constant.OutputConstant.SPLIT_LINE;
import static lotto.constant.OutputConstant.STATISTIC_MESSAGE;

import java.util.List;
import lotto.constant.PrizeConstant;

public class OutputView {
    private static final int START = 3;


    public void printLotto(int quantity, List<List<Integer>> myLottoNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append(NEW_LINE.getMessage() + quantity + PURCHASE_MESSAGE.getMessage() + NEW_LINE.getMessage());

        for (List<Integer> myLottoNumber : myLottoNumbers) {
            sb.append(myLottoNumber + NEW_LINE.getMessage());
        }

        System.out.println(sb);
    }

    public void printStatistics(List<Integer> statistics) {
        StringBuilder sb = new StringBuilder();
        sb.append(NEW_LINE.getMessage() + STATISTIC_MESSAGE.getMessage())
                .append(NEW_LINE.getMessage()).append(SPLIT_LINE.getMessage());

        for (int score = START; score < statistics.size(); score++) {
            String message = PrizeConstant.getMessageByScore(score);
            sb.append(NEW_LINE.getMessage()).append(message + statistics.get(score) + PER.getMessage());
        }

        System.out.println(sb);
    }

    public void printProfitability(double profitability) {
        System.out.println(PROFITABILITY_MESSAGE.getMessage() +
                String.format(PROFITABILITY_FORMAT.getMessage(), profitability) + PERCENT.getMessage());
    }

}
