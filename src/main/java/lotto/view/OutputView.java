package lotto.view;

import java.util.List;
import lotto.model.Lotto;
import lotto.util.message.Guide;

public class OutputView {

    public static void error(String message) {
        System.out.println(message);
    }

    public static void lottoInfo(List<Lotto> lottos, int count) {
        System.out.println(Guide.LOTTO_COUNT.getMessage(count));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
}
