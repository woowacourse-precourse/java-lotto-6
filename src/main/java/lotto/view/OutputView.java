package lotto.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static constant.MessageList.*;

public class OutputView {
    public static void printPurchaseQuantityMessage(int purchaseQuantity) {
        System.out.println(purchaseQuantity + PURCHASE_QUANTITY_MESSAGE);
    }

    public static void printLottoNumbers(List<Integer> lottoNumbers) {
        Collections.sort(lottoNumbers);

        List<String> lotto = lottoNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        System.out.println(lotto);
    }

    public static void printWinningStatistics(List<Integer> winningCount) {
        System.out.println(WINNING_STATISTICS_MESSAGE);
        System.out.println(DIVIDE_LINE);

        System.out.println(FIFTH_PLACE + winningCount.get(0) + NUMBER);
        System.out.println(FOURTH_PLACE + winningCount.get(1) + NUMBER);
        System.out.println(THIRD_PLACE + winningCount.get(2) + NUMBER);
        System.out.println(SECOND_PLACE + winningCount.get(3) + NUMBER);
        System.out.println(FIRST_PLACE + winningCount.get(4) + NUMBER);
    }

    public static void printTotalRateOfReturn(double rateOfReturn) {
        System.out.println(TOTAL_RATE_OF_RETURN_MESSAGE + String.format("%.1f",rateOfReturn) + FINISH_MESSAGE);
    }
}
