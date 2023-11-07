package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_PURCHASED_MESSAGE = "\n%d개를 구매했습니다.";

    public static void printNumberOfLottoPurchased(int numberOfLottosPurchased) {
        System.out.printf(NUMBER_OF_LOTTOS_PURCHASED_MESSAGE, numberOfLottosPurchased);
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println();
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
