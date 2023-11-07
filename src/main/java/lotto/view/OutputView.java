package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {

    private static final String NOTICE_PURCHASE_LOTTO = "%d개를 구매했습니다.\n";

    public void printPurchaseLotto(List<Lotto> purchaseLotto) {
        int purchaseCount = purchaseLotto.size();

        System.out.printf(NOTICE_PURCHASE_LOTTO, purchaseCount);

        for (Lotto lotto : purchaseLotto) {
            System.out.println(lotto.getNumbersToString());
        }
        System.out.println();
    }

    public void printErrorMessage(Exception error) {
        System.out.println(error.getMessage());
    }

    public void printBlank() {
        System.out.println();
    }
}
