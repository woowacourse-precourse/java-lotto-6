package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    private static final String PAY_SUCCESS_MESSAGE = "개를 구매했습니다.";

    public static void printPaySuccessMessageMessage(int lotteCount) {
        System.out.println();
        System.out.println(lotteCount + PAY_SUCCESS_MESSAGE);
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> {
            System.out.print("[");
            lotto.printNumbers();
            System.out.println("]");
        });

    }
}
