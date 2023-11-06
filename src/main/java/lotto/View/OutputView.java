package lotto.View;

import static lotto.Domain.CountLottoAmount.countLottoQuantity;

import java.util.ArrayList;
import java.util.List;
import lotto.Domain.Lotto;
import lotto.Domain.LottoGenerator;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_RESULT_MESSAGE = "당첨 통계";
    private static final String LINE_MESSAGE = "---";
    private static final int MIN_MATCHING_COUNT = 3;
    private static final int MAX_MATCHING_COUNT = 6;

    public static void printLottoAmount(int purchasedAmount) {

        System.out.println(purchasedAmount + LOTTO_AMOUNT_MESSAGE);
    }

    public static void printPurchasedLottoList(List<Lotto> lottoList) {

        for (Lotto lotto : lottoList) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers);
        }
    }

    public static void printMatchingCounts(int[] matchCounts) {
        System.out.println(WINNING_RESULT_MESSAGE);
        System.out.println(LINE_MESSAGE);

        boolean hasBonus = matchCounts[MAX_MATCHING_COUNT] > 0;

        for (int i = MIN_MATCHING_COUNT; i <= MAX_MATCHING_COUNT; i++) {
            int matchCount = matchCounts[i];
            String prizeDescription = getPrizeDescription(i, hasBonus);
            System.out.println(prizeDescription + " - " + matchCount + "개");
        }
    }

    private static String getPrizeDescription(int matchingCount, boolean hasBonus) {
        String prizeDescription = "";

        if (matchingCount == 3) {
            prizeDescription = "3개 일치 (5,000원)";
        } else if (matchingCount == 4) {
            prizeDescription = "4개 일치 (50,000원)";
        } else if (matchingCount == 5) {
            prizeDescription = "5개 일치 (1,500,000원)";
        } else if (matchingCount == 5 && hasBonus) {
            prizeDescription = "5개 일치, 보너스 볼 일치 (30,000,000원)";
        } else if (matchingCount == 6) {
            prizeDescription = "6개 일치 (2,000,000,000원)";
        }
        return prizeDescription;
    }

    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }


}



