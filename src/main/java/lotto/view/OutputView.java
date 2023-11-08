package lotto.view;

import lotto.view.constant.OutputMessageConstants;

import java.util.List;

public class OutputView {
    public void printPurchaseAmountInputMessage() {
        System.out.println(OutputMessageConstants.PURCHASE_AMOUNT_INPUT_MESSAGE.getMessage());
    }

    public void printWinningNumbersInputMessage() {
        System.out.println(OutputMessageConstants.WINNING_NUMBER_INPUT_MESSAGE.getMessage());
    }

    public void printBonusNumberInputMessage() {
        System.out.println(OutputMessageConstants.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
    }

    public void printLottoNumber(List<Integer> lottoNumbers) {
        System.out.println(lottoNumbers);
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(String.format(OutputMessageConstants.PURCHASE_COUNT_OUTPUT_MESSAGE.getMessage(), lottoCount));
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printWinningResult(int matchingCount, int prize, int lottoCount) {
        System.out.println(String.format(OutputMessageConstants.WINNING_RANK_AND_COUNT_OUTPUT_MESSAGE.getMessage(), matchingCount, prize, lottoCount));
    }

    public void printSecondPlace(int matchingCount, int prize, int lottoCount) {
        System.out.println(String.format(OutputMessageConstants.SECOND_RANK_AND_COUNT_OUTPUT_MESSAGE.getMessage(), matchingCount, prize, lottoCount));
    }

    public void printResultMessage() {
        System.out.println(OutputMessageConstants.WINNING_RESULT_OUTPUT_MESSAGE.getMessage());
        System.out.println(OutputMessageConstants.DIVIDER_OUTPUT_MESSAGE.getMessage());
    }

    public void printRateOfReturnMessage(double rate) {
        System.out.print(String.format(OutputMessageConstants.RATE_OF_RETURN_OUTPUT_MESSAGE.getMessage(),rate));
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }
}
