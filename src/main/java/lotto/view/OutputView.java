package lotto.view;

import java.util.List;

public class OutputView {
    private static final String PAID_DONE_MESSGAE = "개를 구매했습니다.";

    public static void printLottos(List<List<Integer>> lottos) {
        print(lottos.size() + PAID_DONE_MESSGAE);
        lottos.forEach(System.out::println);
    }

    private static void print(String message) {
        System.out.println(message);
    }
}
