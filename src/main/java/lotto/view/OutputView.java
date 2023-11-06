package lotto.view;

import java.util.List;
import lotto.Lotto;

public class OutputView {
    private static final String LOTTO_PURCHASE_QUANTITY = "개를 구매했습니다.";
    public static void println(String message) {
        System.out.println(message);
    }

    public static void printLottoList(List<Lotto> lottos) {
        println(lottos.size() + LOTTO_PURCHASE_QUANTITY);
        lottos.forEach(OutputView::printLotto);
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }
}
