package lotto.view;

import static lotto.view.constants.ViewMessage.*;

import camp.nextstep.edu.missionutils.Console;

public class View {
    public String inputValue() {
        return Console.readLine();
    }

    public void printPayAmountInputMessage() {
        System.out.println(PAY_AMOUNT_INPUT.message());
    }

    public void printExceptionMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printPurchasedLottoAmount(int purchasedLottoAmount) {
        System.out.println();
        System.out.printf((PURCHASED_LOTTO.message()), purchasedLottoAmount);
    }

    public void printIssuedLotto(String issuedLotto) {
        System.out.println(issuedLotto);
    }

    public void printWinningNumbersInputMessage() {
        System.out.println(WINNING_NUMBER_INPUT.message());
    }

    public void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT.message());
    }

    public void printWinningStatisticMessage() {
        System.out.println(WINNING_STATISTICS.message());
    }

    public void printLottoResult(String winningPrize, int prizeCount) {
        System.out.printf(LOTTO_RESULT.message(), winningPrize, prizeCount);
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN.message(), rateOfReturn);
    }
}
