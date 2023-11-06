package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class Purchase {
    private final int amount;
    private final List<Lotto> purchasedLotto;

    public Purchase() {
        this.amount = initializeAmount();
        this.purchasedLotto = initializePurchasedLotto();
    }

    public int initializeAmount() {
        return Integer.parseInt(Console.readLine()) / 1000;
    }

    public List<Lotto> initializePurchasedLotto() {
        List<Lotto> purchasedLotto = new ArrayList<>();

        for (int i = 0; i < this.amount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            purchasedLotto.add(lotto);
        }

        return purchasedLotto;
    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> getPurchasedLotto() {
        return purchasedLotto;
    }

    public void printPurchasedLotto() {
        for (int i = 0; i < purchasedLotto.size(); i++) {
            purchasedLotto.get(i).printLottoNumber();
        }
    }
}