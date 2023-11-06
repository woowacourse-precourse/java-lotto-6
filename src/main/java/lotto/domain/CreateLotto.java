package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CreateLotto {
    private List<Lotto> lottos;
    private int amount;

    public Lotto createRandom() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(randomNumbers);
    }

    public void setAmount(Money money) {
        amount = money.getMoney() / 1000;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void multipleLotto() {
        lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Lotto lotto = createRandom();
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
