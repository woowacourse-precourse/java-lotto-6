package lotto.view;

import static lotto.view.viewMessage.ViewMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

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

    public void printIssuedLotto(String lotto) {
        System.out.println(lotto);
    }

    public void printWinningNumbersInputMessage() {
        System.out.println(WINNING_NUMBER_INPUT.message());
    }

    public void printBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBER_INPUT.message());
    }

    public void printLottoResult(List<Integer> lottoResult) {
        System.out.println(LOTTO_RESULT.message());
        System.out.printf(FIFTH_PRIZE.message(), lottoResult.get(5));
        System.out.printf(FORTH_PRIZE.message(), lottoResult.get(4));
        System.out.printf(THIRD_PRIZE.message(), lottoResult.get(3));
        System.out.printf(SECOND_PRIZE.message(), lottoResult.get(2));
        System.out.printf(FIRST_PRIZE.message(), lottoResult.get(1));
    }

    public void printRateOfReturn(double rateOfReturn) {
        System.out.printf(RATE_OF_RETURN.message(), rateOfReturn);
    }
}
