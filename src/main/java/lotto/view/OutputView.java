package lotto.view;

import static lotto.enums.Message.OUTPUT_COUNT_UNIT;
import static lotto.enums.Message.OUTPUT_DIVIDING_LINE;
import static lotto.enums.Message.OUTPUT_PROFIT_RATIO_MESSAGE;
import static lotto.enums.Message.OUTPUT_PURCHASE_QUANTITY_MESSAGE;
import static lotto.enums.Message.OUTPUT_WINNING_STATISTICS_MESSAGE;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import lotto.enums.LottoRank;

public class OutputView {

    public void printPurchaseQuantity(int purchaseQuantity) {
        System.out.println();
        System.out.println(purchaseQuantity + OUTPUT_PURCHASE_QUANTITY_MESSAGE.getMessage());
    }

    public void printPurchasedLottoNumbers(List<List<Integer>> lottoNumbers) {
        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }

    public void printWinningStatistics(EnumMap<LottoRank, Integer> lottoRakingMap) {
        System.out.println(OUTPUT_WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println(OUTPUT_DIVIDING_LINE.getMessage());

        Arrays.stream(LottoRank.values())
                .filter(rank -> rank != LottoRank.LAST_PLACE)
                .forEach(rank ->
                        System.out.println(rank.getOutputMessage()
                                + lottoRakingMap.get(rank) + OUTPUT_COUNT_UNIT.getMessage()));
    }

    public void printProfitRatio(double profit) {
        System.out.printf(OUTPUT_PROFIT_RATIO_MESSAGE.getMessage(), profit);
    }
}
