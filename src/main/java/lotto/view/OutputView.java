package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public static final String PURCHASE_RESULT_MESSAGE = "개를 구매했습니다.";

    public static void printPurchasedLottos(List<Lotto> boughtLotto, int count) {
        System.out.println(count + PURCHASE_RESULT_MESSAGE);
        for (Lotto lotto : boughtLotto) {
            System.out.println(lotto);
        }
    }
}
