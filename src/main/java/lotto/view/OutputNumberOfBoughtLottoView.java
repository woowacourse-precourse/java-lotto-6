package lotto.view;

import lotto.domain.User;

public class OutputNumberOfBoughtLottoView {
    private static final String OUTPUT_MESSAGE = "%d개를 구매했습니다.";

    public static void printBoughtLottos(User lotto) {

        System.out.printf((OUTPUT_MESSAGE) + "%n", lotto.getNumberOfLotto());
    }
}
