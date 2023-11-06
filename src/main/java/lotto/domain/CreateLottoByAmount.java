package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class CreateLottoByAmount extends CreateLotto {
    private List<Lotto> lottos = new ArrayList<>();
    public int amount;

    public void setAmount(Money money) {
        amount = money.getMoney() / 1000;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void multipleLotto() {
        for (int i = 0; i < amount; i++) {
            Lotto lotto = create();
            lottos.add(lotto);
        }
    }

    public int getAmount() {
        return amount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
