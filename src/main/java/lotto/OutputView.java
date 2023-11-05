package lotto;

import java.util.List;

public class OutputView {
    private static final String PURCHASE_QUANTITY_MESSAGE = "개를 구매했습니다.";

    public void printPurchaseQuantity(int purchaseQuantity) {
        System.out.println();
        System.out.println(purchaseQuantity + PURCHASE_QUANTITY_MESSAGE);
    }

    public void printPurchasedLottoNumbers(List<List<Integer>> lottoNumbers) {
        for (List<Integer> lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }
}
