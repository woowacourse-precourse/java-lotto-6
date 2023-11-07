package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String INFO_PURCHASE_LOTTO = "개를 구매했습니다.";

    public static void printLottoNums(List<Lotto> list) {
        System.out.println(list.size() + INFO_PURCHASE_LOTTO);

        for (Lotto lotto : list) {
            System.out.println(lotto);
        }
    }
}
