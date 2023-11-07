package lotto.view;

import lotto.Lotto;
import lotto.values.ExceptionMessage;
import lotto.values.WinningResult;

import java.util.ArrayList;
import java.util.List;

import static lotto.values.ExceptionMessage.ERROR;
import static lotto.values.GuideMessage.*;

public class Output {
    public void printError(String exceptionMessage){
        System.out.println(ERROR.getMessage() + exceptionMessage);
    }
    public void printMoneyPrompt() {
        System.out.println(REQUEST_MONEY_MESSAGE.getMessage());
    }

    public void printPurchasedResult(int purchasedLottoNum) {
        System.out.printf(PURCHASED_MESSAGE.getMessage(), purchasedLottoNum);
    }

    public void printWinningNumberPrompt() {
        System.out.println(REQUEST_WINNING_NUMBER_MESSAGE.getMessage());
    }

    public void printBonusNumberPrompt() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE.getMessage());
    }

    public void printResult() {
        System.out.println(RESULT_MESSAGE.getMessage());
    }

    public void printWinning(ArrayList<Integer> winningResult) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < WinningResult.values().length; i++) {
            sb.append(String.format(WinningResult.values()[i].getMessage(), winningResult.get(i)));
        }
        System.out.println(sb);
    }

    public void printEarnings(float earningsRate) {
        System.out.printf(TOTAL_EARNINGS_RATE_MESSAGE.getMessage(), earningsRate);
    }

    public void printLotto(List<Lotto> lottoPackage){
        for(Lotto lotto : lottoPackage) {
            System.out.println(lotto.getNumbers());
        }
    }

}
