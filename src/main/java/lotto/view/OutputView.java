package lotto.view;

import lotto.view.constant.OutputMessageConstants;

import java.util.List;

public class OutputView {
    public static void printOutputMessage(String message) {
        System.out.println(message);
    }

    public static void printLottoNumber(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public static void printLottoCount(int lottoCount) {
        System.out.println(String.format(OutputMessageConstants.PURCHASE_COUNT_OUTPUT_MESSAGE.getMessage(), lottoCount));
    }

    public static void printNewLine() {
        System.out.println();
    }

    public static void printWinningResult(int matchingCount, int prize, int lottoCount) {
        System.out.println(String.format(OutputMessageConstants.WINNING_RANK_AND_COUNT_OUTPUT_MESSAGE.getMessage(), matchingCount, prize, lottoCount));
    }

    public static void printSecondPlace(int matchingCount, int prize, int lottoCount) {
        System.out.println(String.format(OutputMessageConstants.SECOND_RANK_AND_COUNT_OUTPUT_MESSAGE.getMessage(), matchingCount, prize, lottoCount));
    }

    public static void printRateOfReturnMessage(double rate) {
        System.out.print(String.format(OutputMessageConstants.RATE_OF_RETURN_OUTPUT_MESSAGE.getMessage(),rate));
    }
}
