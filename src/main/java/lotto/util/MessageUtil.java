package lotto.util;

import lotto.constant.view.InputView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static lotto.constant.LottoPrice.SECOND;
import static lotto.constant.view.InputView.*;
import static lotto.constant.view.OutputView.*;

public class MessageUtil {
    public void printPurchaseInput() {
        System.out.println(PURCHASE_MESSAGE.getMessage());
    }

    public void printWinningInput() {
        System.out.println(WINNING_NUMBER_MESSAGE.getMessage());
    }

    public void printBonusInput() {
        System.out.println(BONUS_NUMBER_MESSAGE.getMessage());
    }

    public void printPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + PURCHASE_COUNT_MESSAGE.getMessage());
    }

    public void printPurchaseInfo(List<Integer> lottoNumbers) {
        List<Integer> sortLottoNumbers = new ArrayList<>(lottoNumbers);
        sortLottoNumbers.sort(Comparator.naturalOrder());

        StringBuilder lottoNumber = new StringBuilder("");

        lottoNumber.append("[");
        for (Integer number : sortLottoNumbers) {
            lottoNumber.append(number).append(", ");
        }
            lottoNumber.delete(lottoNumber.length()-2, lottoNumber.length()).append("]");

            System.out.println(lottoNumber);
    }

    public void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS_MESSAGE.getMessage());
    }

    public void printWinningResult(int number, int price, int matchCount) {
        String priceWithComma = String.format("%,d", price);
        if (number == SECOND.getNumber()) {
            System.out.printf(BONUS_RESULT_MESSAGE.getMessage(), priceWithComma, matchCount);
            return;
        }
        System.out.printf(WINNING_RESULT_MESSAGE.getMessage(), number, priceWithComma, matchCount);
    }

    public void printEarningRate(Double rate) {
        System.out.printf(EARNING_RATE_MESSAGE.getMessage(), rate);
    }
}
