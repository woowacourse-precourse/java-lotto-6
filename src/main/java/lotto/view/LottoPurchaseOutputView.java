package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoPurchaseOutputView {

    private final static String LOTTO_COUNT = "개를 구매했습니다.";

    public void printLotto(Lottos lottos, int lottoCount) {
        System.out.println(lottoCount + LOTTO_COUNT);
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            printOneLotto(lotto);
        }
    }

    public void printOneLotto(Lotto lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.size(); i++) {
            System.out.print(lotto.get(i));
            if (i != lotto.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]");
    }

}
