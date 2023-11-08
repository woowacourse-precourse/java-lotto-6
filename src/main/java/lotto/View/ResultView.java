package lotto.View;

import static lotto.Util.ViewConstant.RESULT_FORMAT;

public class ResultView {
    public static void printResult(int[] lottoResult, double profitMargin) {
        String result = String.format(
                RESULT_FORMAT,
                lottoResult[4], lottoResult[3], lottoResult[2], lottoResult[1], lottoResult[0],
                profitMargin);

        System.out.println(result);
    }
}
