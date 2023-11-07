package lotto.domain;

import static lotto.domain.GameConstant.LOTTO_PRICE;
import static lotto.domain.GameConstant.LOTTO_SIZE;
import static lotto.domain.GameConstant.MAXIMUM_LOTTO_NUMBER;
import static lotto.domain.GameConstant.MINIMUM_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class CreateLotto {
    private List<Lotto> lottos;
    private int amount;

    public Lotto createRandom() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_LOTTO_NUMBER, MAXIMUM_LOTTO_NUMBER, LOTTO_SIZE);
        return new Lotto(randomNumbers);
    }

    public void setAmount(Money money) {
        amount = money.getMoney() / LOTTO_PRICE;
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
