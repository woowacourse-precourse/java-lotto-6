package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public static void printPurchasedLotto(List<Lotto> purchasedLotto) {
        System.out.println(purchasedLotto.size() + "개를 구매했습니다.");
        for(Lotto lotto : purchasedLotto) {
            System.out.print("[");
            System.out.print(String.join(",", lotto.getNumbers()
                    .stream()
                    .map(String::valueOf)
                    .toList()));
            System.out.println("]");
        }
        System.out.println();
    }
}
