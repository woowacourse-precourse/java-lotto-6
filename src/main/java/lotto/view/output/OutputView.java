package lotto.view.output;

import java.math.BigDecimal;
import java.util.List;

import lotto.common.LottoCommonString;

public class OutputView {
    private static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printNewLine() {
        printMessage("");
    }

    public static void printInputLottoBuyNumber() {
        printMessage(LottoCommonString.INPUT_LOTTO_BUY_NUMBER.getMessage());
    }

    public static void printLottoBuySuccess(int lottoCount) {
        printMessage(String.format(LottoCommonString.FORMAT_LOTTO_BUY_SUCCESS.getMessage(), lottoCount));
    }

    public static void printGeneratedLottoNumber(List<Integer> lottoNumbers) {
        printMessage(lottoNumbers.toString());
    }

    public static void printInputWinnerLottoNumber() {
        printMessage(LottoCommonString.INPUT_WINNER_LOTTO_NUMBER.getMessage());
    }

    public static void printInputBonusNumber() {
        printMessage(LottoCommonString.INPUT_BONUS_NUMBER.getMessage());
    }

    public static void printLottoWinnerStatus() {
        printMessage(LottoCommonString.LOTTO_WINNER_STATUS.getMessage());
    }

    public static void printLottoResultLine() {
        printMessage(LottoCommonString.LOTTO_RESULT_LINE.getMessage());
    }

    public static void printLottoWinnerTableResult(List<String> winnerTable) {
        winnerTable.stream().forEach(OutputView::printMessage);
    }

    public static void printProfitRate(BigDecimal profitRate) {
        printMessage(String.format(LottoCommonString.FORMAT_PROFIT_RATE.getMessage(), profitRate));
    }

    public static void printErrorMessage(IllegalArgumentException e) {
        printMessage(e.getMessage());
    }
}
