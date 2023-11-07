package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {
    public static void showPurchaseCount(int purchaseCount) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void showPurchaseLotto(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}
