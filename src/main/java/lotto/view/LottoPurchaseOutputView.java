package lotto.view;

import lotto.model.Lotto;
import lotto.model.Lottos;

public class LottoPurchaseOutputView {

    private final static String LOTTO_COUNT = "개를 구매했습니다.";
    private final static String OUTPUT_MONEY = "구입금액을 입력해 주세요.";

    public void outputLotto(Lottos lottos, int lottoCount) {
        System.out.println();
        System.out.println(lottoCount + LOTTO_COUNT);
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            outputOneLotto(lotto);
        }
    }

    public void outputOneLotto(Lotto lotto) {
        System.out.print("[");
        for (int i = 0; i < lotto.size(); i++) {
            System.out.print(lotto.get(i));
            if (i != lotto.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void outputMoneyMessage() {
        System.out.println(OUTPUT_MONEY);
    }

}
