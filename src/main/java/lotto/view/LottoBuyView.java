package lotto.view;

import lotto.Lotto;

import java.util.List;

public class LottoBuyView {
    public void printPurchaseLog(List<Lotto> purchasedLotto, int count) {
        System.out.printf("\n%d개를 구매했습니다.\n", count);
        for (Lotto lotto : purchasedLotto) {
            lotto.printLotto();
        }
    }

}
