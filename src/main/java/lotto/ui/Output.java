package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;

public class Output {
    private static final String NEW_LINE = "\n";
    private static String PURCHASE_MESSAGE = "개를 구매했습니다.";

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printLottos(List<Lotto> lottos) {
        int count = lottos.size();
        System.out.println(NEW_LINE + count + PURCHASE_MESSAGE);
        for (int i = 0; i < count; ++i) {
            System.out.println(lottos.get(i).getNumbers());
        }
    }
}
