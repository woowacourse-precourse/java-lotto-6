package lotto;

import java.util.List;

public class MessagePrinter {
    public static final String INPUT_FOR_PURCHASE_AMOUNT = "구입금액을 입력해주세요.";
    public static final String COMPLETE_PURCHASE = "개를 구매했습니다.";

    public static void askPurchaseAmount() {
        System.out.println(INPUT_FOR_PURCHASE_AMOUNT);
    }

    public static void printCompletePurchase(int purchaseCount, List<Lotto> lottoNumbers) {
        System.out.println("\n" + purchaseCount + COMPLETE_PURCHASE);
        for (Lotto lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
    }
}
