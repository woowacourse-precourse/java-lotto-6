package lotto;

import java.util.List;

public class MessagePrinter {
    public static final String INPUT_FOR_PURCHASE_AMOUNT = "구입금액을 입력해주세요.";
    public static final String COMPLETE_PURCHASE = "개를 구매했습니다.";
    public static final String INPUT_FOR_WINNING_LOTTO = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_FOR_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static void askPurchaseAmount() {
        System.out.println(INPUT_FOR_PURCHASE_AMOUNT);
    }

    public static void printCompletePurchase(int purchaseCount, List<Lotto> lottoNumbers) {
        System.out.println("\n" + purchaseCount + COMPLETE_PURCHASE);
        for (Lotto lottoNumber : lottoNumbers) {
            System.out.println(lottoNumber);
        }
        System.out.println();
    }

    public static void askWinningLotto() {
        System.out.println(INPUT_FOR_WINNING_LOTTO);
    }

    public static void askBonusNumber() {
        System.out.println(INPUT_FOR_BONUS_NUMBER);
    }
}
