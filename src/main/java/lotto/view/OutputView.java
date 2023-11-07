package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_PURCHASED_MESSAGE = "%d개를 구매했습니다.";

    public static void printNumberOfPurchasedLotto(int numberOfPurchasedLotto) {
        System.out.printf(NUMBER_OF_LOTTOS_PURCHASED_MESSAGE,numberOfPurchasedLotto);
        System.out.println();
    }
    public static void printLottosList(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.toString());
            System.out.println();
        }
    }
}
