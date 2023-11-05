package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    private static final String LOTTO_NUMBER_DELIMITER = ", ";
    private static final String OPEN_BRACKET = "[";
    private static final String CLOSE_BRACKET = "]";
    private static final int DIVIDER_FOR_COUNT_PURCHASE_AMOUNT = 1000;
    private static final String PURCHASE_COUNT_ALERT = "개를 구매했습니다.";
    private static final int LOTTO_NUMBERS_COUNT = 6;



    public static void printPurchaseAmount(int purchaseMoney){
        int purchaseAmount = purchaseMoney / DIVIDER_FOR_COUNT_PURCHASE_AMOUNT;
        System.out.println(purchaseAmount + PURCHASE_COUNT_ALERT);
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
            System.out.print(number + LOTTO_NUMBER_DELIMITER);
        }
        System.out.println(lottoNumbers.get(LOTTO_NUMBERS_COUNT - 1) + CLOSE_BRACKET);
    }
}
