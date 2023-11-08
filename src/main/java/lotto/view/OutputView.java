package lotto.view;

import lotto.utils.Constant;

import java.util.List;

public class OutputView {

    public static void outputLottoCount(int count) {
        System.out.println(count + Constant.OUTPUT_VIEW_LOTTO_COUNT);
    }

    public static void outputLottoNumbers(List<String> numbers) {
        String result = String.join(", ", numbers);
        System.out.println("[" + result + "]");
    }

    public static void outputStatistic(String description, String prize, int count) {
        System.out.println(description + " (" + prize + "원) - " + count + "개");
    }

    public static void outputRate(double rate) {
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }

    public static void outputBlank() {
        System.out.println("");
    }

    public static void outputWinningStatistics() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
