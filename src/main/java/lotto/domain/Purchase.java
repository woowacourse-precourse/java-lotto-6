package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class Purchase {
    private final int amount;
    private final List<Lotto> purchasedLotto = new ArrayList<>();

    public Purchase(final String amount) {
        this.amount = Integer.parseInt(amount) / 1000;
        purchaseLotto();
    }

    public void purchaseLotto() {
        for (int i = 0; i < this.amount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            purchasedLotto.add(lotto);
        }
    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }

    public void printPurchasedLotto() {
        for (int i = 0; i < purchasedLotto.size(); i++) {
            purchasedLotto.get(i).getLottoNumber();
        }
    }
}