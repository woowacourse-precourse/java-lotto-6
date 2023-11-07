package lotto.view;

import java.util.List;
import java.util.StringJoiner;
import lotto.Lotto;

public class OutputView {

    public static void printPurchasedLottoCount(Integer lottoCount) {
        System.out.println();
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printPurchasedLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    private static void printLotto(Lotto lotto) {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");

        for (Integer num : lotto.getNumbers()) {
            joiner.add(num.toString());
        }

        String result = joiner.toString();
        System.out.println(result);
    }
}
