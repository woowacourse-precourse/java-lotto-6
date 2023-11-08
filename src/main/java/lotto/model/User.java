package lotto.model;

import java.util.List;

public class User {

    private int money;
    private List<Lotto> purchasedLotto;
    private final LottoStore lottoStore = LottoStore.getInstance();

    public void enterDraw(int money) {
        this.money = money;
        purchaseLotto(money);
    }

    private void purchaseLotto(int money) {
        this.purchasedLotto = lottoStore.buyLotto(money);
    }

    public int getMoney() {
        return money;
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }
}
