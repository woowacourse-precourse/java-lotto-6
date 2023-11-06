package lotto.model;

import java.util.List;

public class UserLotto {

    private int lottoCount;
    private List<Lotto> lottos;

    private void moneyToLotto(int money) {
        this.lottoCount = money / 1000;
    }
}
