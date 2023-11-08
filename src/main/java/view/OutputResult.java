package view;

import model.WinningPrice;
import model.WinningPriceResult;
import model.ReturnRate;

import java.util.Arrays;

public class OutputResult {
    private static final String NEWLINE = "\n";
    private static final String OUTPUT_TOP_MESSAGE = "당첨 통계" + NEWLINE + "---";
    private static final String OUTPUT_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String OUTPUT_SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";
    private static final String OUTPUT_RATE_OF_RETURN = "총 수익률은 %.1f%%입니다.";

    public static void printOutputResult(WinningPriceResult winningPriceResult, ReturnRate rate) {
        System.out.println(OUTPUT_TOP_MESSAGE);
        Arrays.stream(WinningPrice.values()).filter(prize -> !prize.equals(WinningPrice.CORRECT_ZERO)).forEach(prize -> System.out.println(getPrintResultPrize(prize, winningPriceResult)));
        System.out.printf((OUTPUT_RATE_OF_RETURN) + NEWLINE, rate.getRate());
    }

    private static String getPrintResultPrize(WinningPrice winningPrice, WinningPriceResult winningPriceResult) {
        if (winningPrice == WinningPrice.CORRECT_FIVE_BONUS) {
            return String.format(OUTPUT_SECOND_RESULT_MESSAGE, winningPrice.getCorrectLottoNumber(), String.format("%,d", winningPrice.getWinningPrice()), winningPriceResult.getWininngPriceCount(winningPrice));
        }

        return String.format(OUTPUT_RESULT_MESSAGE, winningPrice.getCorrectLottoNumber(), String.format("%,d", winningPrice.getWinningPrice()), winningPriceResult.getWininngPriceCount(winningPrice));
    }
}