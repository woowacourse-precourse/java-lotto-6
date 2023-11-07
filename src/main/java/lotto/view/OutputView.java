package lotto.view;

import static lotto.util.OutputViewMessage.INPUT_BONUS_NUMBER;
import static lotto.util.OutputViewMessage.INPUT_PURCHASE_PRICE;
import static lotto.util.OutputViewMessage.INPUT_WINNING_NUMBERS;
import static lotto.util.OutputViewMessage.PURCHASE_MESSAGE;
import static lotto.util.OutputViewMessage.TOTAL_PROFIT_RATE;
import static lotto.util.OutputViewMessage.WINNING_STATISTICS;

import java.util.List;

public class OutputView {

    public static void printPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE);
    }

    public static void printPurchaseMessage(int lottoPurchaseCount) {
        System.out.printf(PURCHASE_MESSAGE, lottoPurchaseCount);
    }

    public static void printInputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
    }

    public static void printInputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
    }

    public static void printWinningStatistics() {
        System.out.println(WINNING_STATISTICS);
    }

    public static void printTOtalProfitRate() {
        System.out.println(TOTAL_PROFIT_RATE);
    }

    public static void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        lottoNumbers.stream().forEach(lottoNumber -> System.out.println(lottoNumber));
    }

}
