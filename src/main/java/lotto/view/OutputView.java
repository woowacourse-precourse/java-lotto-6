package lotto.view;

import static lotto.model.LottoRanking.FIFTH;
import static lotto.model.LottoRanking.FIRST;
import static lotto.model.LottoRanking.FORTH;
import static lotto.model.LottoRanking.SECOND;
import static lotto.model.LottoRanking.THIRD;
import static lotto.util.OutputViewMessage.FIFTH_PRINT_MESSAGE;
import static lotto.util.OutputViewMessage.FIRST_PRINT_MESSAGE;
import static lotto.util.OutputViewMessage.FORTH_PRINT_MESSAGE;
import static lotto.util.OutputViewMessage.INPUT_BONUS_NUMBER;
import static lotto.util.OutputViewMessage.INPUT_PURCHASE_PRICE;
import static lotto.util.OutputViewMessage.INPUT_WINNING_NUMBERS;
import static lotto.util.OutputViewMessage.PURCHASE_MESSAGE;
import static lotto.util.OutputViewMessage.SECOND_PRINT_MESSAGE;
import static lotto.util.OutputViewMessage.THIRD_PRINT_MESSAGE;
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

    public static void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        lottoNumbers.stream().forEach(lottoNumber -> System.out.println(lottoNumber));
    }

    public static void printLottoStatistics() {
        System.out.printf(FIFTH_PRINT_MESSAGE, FIFTH.getPrizeMoney(), FIFTH.getCount());
        System.out.printf(FORTH_PRINT_MESSAGE, FORTH.getPrizeMoney(), FORTH.getCount());
        System.out.printf(THIRD_PRINT_MESSAGE, THIRD.getPrizeMoney(), THIRD.getCount());
        System.out.printf(SECOND_PRINT_MESSAGE, SECOND.getPrizeMoney(), SECOND.getCount());
        System.out.printf(FIRST_PRINT_MESSAGE, FIRST.getPrizeMoney(), FIRST.getCount());
    }

    public static void printLottoProfit(String lottoProfit) {
        System.out.printf(TOTAL_PROFIT_RATE, lottoProfit);
    }
}
