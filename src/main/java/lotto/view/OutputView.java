package lotto.view;

import java.util.List;
import java.util.Map;

import static lotto.util.MessageConstant.*;
import static lotto.util.NumberConstant.*;

public class OutputView {
    public void printLottoNumAndNumbers(int num, List<String> texts) {
        System.out.printf(LOTTO_NUM_OUTPUT, num);
        texts.forEach(System.out::println);
    }

    public void printLottoResult(Map<Integer, Integer> countResult) {
        System.out.println(LOTTO_RESULT);
        System.out.println(DELIMITER);
        System.out.printf(FIFTH_OUTPUT, countResult.getOrDefault(FIFTH_NUM_KEY, 0));
        System.out.printf(FOURTH_OUTPUT, countResult.getOrDefault(FOURTH_NUM_KEY, 0));
        System.out.printf(THIRD_OUTPUT, countResult.getOrDefault(THIRD_NUM_KEY, 0));
        System.out.printf(SECOND_OUTPUT, countResult.getOrDefault(SECOND_NUM_KEY, 0));
        System.out.printf(FIRST_OUTPUT, countResult.getOrDefault(FIRST_NUM_KEY, 0));
    }

    public void printRevenueRatio(Double revenueRatio) {
        System.out.printf(REVENUE_RATIO_OUTPUT, revenueRatio);
    }
}
