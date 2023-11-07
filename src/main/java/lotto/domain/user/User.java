package lotto.domain.user;

import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.SaleLotto;
import lotto.domain.shop.Shop;

public class User {
    private int spendingMoney = 0;
    private List<SaleLotto> lottos;

    public User() {
    }

    public void buyLotto(int price, Shop shop) {
        lottos = shop.sellLotto(price);
        this.spendingMoney = spendingMoney;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
