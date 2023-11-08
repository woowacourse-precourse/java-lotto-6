package lotto.view;

import static lotto.constant.OutputText.ENTER_BONUS_NUMBER;
import static lotto.constant.OutputText.ENTER_PURCHASE_AMOUNT;
import static lotto.constant.OutputText.ENTER_WINNING_NUMBERS;
import static lotto.constant.OutputText.WINNING_STATISTICS;

import lotto.constant.OutputText;
import lotto.dto.LottosInfo;
import lotto.dto.RateOfReturn;
import lotto.dto.WinningStatistics;

public class OutputView {

    public void printEnterPurchaseAmount() {
        printOutputText(ENTER_PURCHASE_AMOUNT);
    }

    public void printEnterWinningNumbers() {
        printOutputText(ENTER_WINNING_NUMBERS);
    }

    public void printEnterBonusNumber() {
        printOutputText(ENTER_BONUS_NUMBER);
    }

    public void printLottosInfo(LottosInfo lottoInfos) {
        printText(lottoInfos.getLottoCountText());
        lottoInfos.numbers().forEach(this::printText);
        printSpace();
    }

    public void printStartMatchingWinningLotto() {
        printSpace();
        printOutputText(WINNING_STATISTICS);
    }

    public void printWinningStatistics(WinningStatistics winningStatistics) {
        printText(winningStatistics.toString());
    }

    public void printRateOfReturn(RateOfReturn rateOfReturn) {
        printText(rateOfReturn.toString());
    }

    public void printText(String text) {
        System.out.println(text);
    }

    public void printSpace() {
        System.out.println();
    }

    private void printOutputText(OutputText outputText) {
        System.out.println(outputText.toString());
    }
}
