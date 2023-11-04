package lotto.function;

import lotto.constant.ProgressMessage;

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
        System.out.println(lottoNumbers);

    }

    public void printWinningResult() {
        System.out.println(ProgressMessage.OUTPUT_STATISTICS);
        System.out.println(ProgressMessage.THREE_WINNING);
        System.out.println(ProgressMessage.FOUR_WINNING);
        System.out.println(ProgressMessage.FIVE_WINNING);
        System.out.println(ProgressMessage.BONUS_WINNING);
        System.out.println(ProgressMessage.SIX_WINNING);
    }

    public void printRateOfReturn() {
        System.out.println(ProgressMessage.RATE_OF_RETURN);
    }
}
