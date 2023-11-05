package lotto.view;

import java.util.List;

public class OutputView {

    private static final String LEFT_LOTTO_BRACKET = "[";
    private static final String RIGHT_LOTTO_BRACKET = "]";

    public static void printLottosByAmount(List<List<Integer>> lottos) {
        for(List<Integer> lotto: lottos) {
            printLottoByAmount(lotto);
        }
    }

    private static void printLottoByAmount(List<Integer> lotto) {
        System.out.println(LEFT_LOTTO_BRACKET);
        String result = String.join(", ", lotto.toString());
        System.out.println(result);
        System.out.println(RIGHT_LOTTO_BRACKET);
    }
}
