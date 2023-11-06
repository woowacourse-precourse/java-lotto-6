package lotto.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {
    private static final String LOTTO_COUNT = "개를 구매했습니다.";

    public void showLottoCount(int count) {
        System.out.println();
        System.out.println(count + LOTTO_COUNT);
    }

    public void showLottos(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            System.out.println(lotto.toString());
        }
    }
}
