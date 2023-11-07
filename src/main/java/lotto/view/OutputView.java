package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.List;

import static lotto.service.LottoService.*;
import static lotto.util.Constant.LOTTO_NUMBERS_COUNT;

public class OutputView {

    private static final String LOTTO_NUMBER_DELIMITER_FOR_OUTPUT = ", ";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final String PURCHASE_COUNT_ALERT = "개를 구매했습니다.";
    private static final String WINNING_STATUS = "당첨 통계\n---";
    private static final String TOTAL_EARNING_RATIO = "총 수익률은 %.1f%%입니다.\n";

    public static void printPurchaseAmount(int purchaseAmount){
        System.out.println(purchaseAmount + PURCHASE_COUNT_ALERT);
        System.out.println();
    }

    public static void printAllPurchaseLotto(List<Lotto> lottoNumbers) {
        for (Lotto purchasedNumbers : lottoNumbers) {
            printPurchaseLotto(purchasedNumbers);
        }
        System.out.println();
    }

    public static void printPurchaseLotto(Lotto purchasedNumbers) {
        System.out.print(OPEN_BRACKET);
        List<Integer> lottoNumbers = purchasedNumbers.getLotto();
        for (int i = 0;i < LOTTO_NUMBERS_COUNT - 1; ++i) {
            int number = lottoNumbers.get(i);
            System.out.print(number + LOTTO_NUMBER_DELIMITER_FOR_OUTPUT);
        }
        System.out.println(lottoNumbers.get(LOTTO_NUMBERS_COUNT - 1) + CLOSE_BRACKET);
    }

    public static void printWinningStatus(){
        System.out.println(WINNING_STATUS);
        for (Rank rank : Rank.values()) {
            String resultMessage = String.format(rank.getRankMessage(), rank.getWinningAmount());
            System.out.println(resultMessage);
        }
    }

    public static void printEarningRatio(int purchaseAmount){
        double earningRatio = calculateEarningRatio(purchaseAmount);
        System.out.printf(TOTAL_EARNING_RATIO, earningRatio);
    }
}
