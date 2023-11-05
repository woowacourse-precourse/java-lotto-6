package lotto.View;


import java.util.List;
import lotto.Model.Lotto;

public class UIView {
    private static final String ENTER_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_ANOUNCE = "개를 구매했습니다.";
    public static void printPurchasePriceInstruction() {
        System.out.println(ENTER_PURCHASE_PRICE);
    }

    public static void printLottoCount(List<Lotto> lottos) {
        System.out.println();
        System.out.println(lottos.size() + PURCHASE_ANOUNCE);
    }

}
