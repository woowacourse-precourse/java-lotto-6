package lotto.view;

import lotto.domain.model.Lotto;

import java.util.List;

public class OutputView {

    public static void printPurchaseCount(int purchaseCount) {
        System.out.println();
        System.out.println(purchaseCount + "개를 구매했습니다.");
    }

    public static void printPurchasedLotto(List<Lotto> purchasedLotto) {
        for (int i = 0; i < purchasedLotto.size(); i++) {
            System.out.println(purchasedLotto.get(i).getLotto());
        }
    }
}
