package lotto.domain;

import java.util.ArrayList;
import lotto.constants.LottoRules;
import lotto.utils.Validation;

public class User {
    private final ArrayList<Lotto> lottos = new ArrayList<>();
    private final Amount purchaseAmount;

    public User(Amount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Amount getPurchaseAmount() {
        return purchaseAmount;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }
    public ArrayList<Lotto> getLottos() {
        return lottos;
    }
}
