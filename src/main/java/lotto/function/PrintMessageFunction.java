package lotto.function;

import lotto.constant.ProgressMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintMessageFunction {

    public void printMoneyInput() {
        System.out.println(ProgressMessage.INPUT_MONEY);
    }

    public void printWinningNumbers() {
        System.out.println(ProgressMessage.INPUT_WINNING_NUMBERS);
    }

    public void printBonusNumber() {
        System.out.println(ProgressMessage.INPUT_BONUS_NUMBERS);
    }

    public void printBuyResult(int buyResult) {
        System.out.println(buyResult + ProgressMessage.BUY_RESULT);
    }

    public void printLottoNumbers(List<Integer> lottoNumbers) {
        List<Integer> sortLottoNums = new ArrayList<>(lottoNumbers);
        Collections.sort(sortLottoNums);
        System.out.println(sortLottoNums);
    }

    public void printWinningStat() {
        System.out.println(ProgressMessage.OUTPUT_STATISTICS);
    }

    public void printThreeWinningResult(int winningCount) {
        System.out.printf(ProgressMessage.THREE_WINNING, winningCount);
    }

    public void printFourWinningResult(int winningCount) {
        System.out.printf(ProgressMessage.FOUR_WINNING, winningCount);
    }

    public void printFiveWinningResult(int winningCount) {
        System.out.printf(ProgressMessage.FIVE_WINNING, winningCount);
    }

    public void printSixWinningResult(int winningCount) {
        System.out.printf(ProgressMessage.SIX_WINNING, winningCount);
    }

    public void printBonusWinningResult(int winningCount) {
        System.out.printf(ProgressMessage.BONUS_WINNING, winningCount);
    }

    public void printRateOfReturn(double rate) {
        System.out.printf(ProgressMessage.RATE_OF_RETURN, rate);
    }
}
