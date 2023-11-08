package lotto.global.utils.view;

import lotto.global.utils.constant.OutputType;

import java.util.List;

public class OutputView {

    private OutputView() {
    }

    public static void commonOutputLine(String output) {
        System.out.println(output);
    }

    public static void outputRandomList(List<Integer> randomList) {
        System.out.println(randomList);
    }

    public static void outputStatistics(List<Integer> correctCountList) {
        System.out.println(OutputType.OUTPUT_WINNING_STATISTICS_5.getComment()
                + correctCountList.get(4) + OutputType.OUTPUT_COUNT.getComment());
        System.out.println(OutputType.OUTPUT_WINNING_STATISTICS_4.getComment()
                + correctCountList.get(3) + OutputType.OUTPUT_COUNT.getComment());
        System.out.println(OutputType.OUTPUT_WINNING_STATISTICS_3.getComment()
                + correctCountList.get(2) + OutputType.OUTPUT_COUNT.getComment());
        System.out.println(OutputType.OUTPUT_WINNING_STATISTICS_2.getComment()
                + correctCountList.get(1) + OutputType.OUTPUT_COUNT.getComment());
        System.out.println(OutputType.OUTPUT_WINNING_STATISTICS_1.getComment()
                + correctCountList.get(0) + OutputType.OUTPUT_COUNT.getComment());
    }

    public static void outputRateOfReturn(double rateOfReturn) {
        System.out.println(OutputType.OUTPUT_RESULT_1.getComment()
                + rateOfReturn + OutputType.OUTPUT_RESULT_2.getComment());
    }
}
