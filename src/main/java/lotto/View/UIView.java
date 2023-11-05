package lotto.View;


import java.util.List;
import lotto.Model.Lotto;

public class UIView {
    private static final String ENTER_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_ANOUNCE = "개를 구매했습니다.";
    private static final String ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    public static void printPurchasePriceInstruction() {
        System.out.println(ENTER_PURCHASE_PRICE);
    }

    public static void printLottoCount(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + PURCHASE_ANOUNCE);
    }

    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public static void printWinningNumberInstruction() {
        System.out.println();
        System.out.println(ENTER_WINNING_NUMBER);
    }
}
