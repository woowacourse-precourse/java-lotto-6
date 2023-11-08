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
}
