package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {

    public void showPurchasedLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }
}
