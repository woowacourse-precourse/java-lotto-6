package lotto.view;

import lotto.Util;
import lotto.Constants;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Prize;

public class OutputView {

    public static void printQuantity(int quantity) {
        System.out.println();
        System.out.printf("%s%s\n", quantity, Constants.QUANTITY_RESULT);
    }

    public static void printRandomLotto(List<List<Integer>> randomLotto) {
        for (List<Integer> numbers : randomLotto) {
            String numberStr = numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(numberStr);
        }
        System.out.println();
    }

    public static void printWinningData(int[] count) {
        System.out.printf("%s\n", Constants.LOTTO_RESULT);
        System.out.printf("%s\n", Constants.DASHES);
        System.out.printf("%s%s%d%s\n", Constants.THREE_RESULT, Constants.DASH, count[0], Constants.NUMBER);
        System.out.printf("%s%s%d%s\n", Constants.FOUR_RESULT, Constants.DASH, count[1], Constants.NUMBER);
        System.out.printf("%s%s%d%s\n", Constants.FIVE_RESULT, Constants.DASH, count[2], Constants.NUMBER);
        System.out.printf("%s%s%d%s\n", Constants.FIVE_BONUS_RESULT, Constants.DASH, count[3], Constants.NUMBER);
        System.out.printf("%s%s%d%s\n", Constants.SIX_RESULT, Constants.DASH, count[4], Constants.NUMBER);
    }

    public static void printRate(double rate) {
        if (Double.isInfinite(rate)) {
            System.out.println("총 수익률은 0.0%입니다.");
            return;
        }
        //System.out.printf("%s %.1f%% %s\n", Constants.TOTAL, rate, Constants.END);
        //String formattedRate = Util.getFormattedPrizeAmount(rate);
        //System.out.printf("총 수익률은 %.1f%% %s\n", Double.parseDouble(formattedRate), Constants.END);
        System.out.printf("%s%s%s","총 수익률은 ", String.format("%.1f",rate), "%입니다.");

    }
}