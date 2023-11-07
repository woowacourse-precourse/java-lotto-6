package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomLottos {
    private int counting;
    private List<Lotto> randomLottos;

    public RandomLottos(Price price) {
        this.counting = price.countPurchasedLotto();
        this.randomLottos = createRandomLottos(counting);
    }

    public List<Lotto> getRandomLottos() {
        return randomLottos;
    }

    public int getCounting() {
        return counting;
    }

    private List<Lotto> createRandomLottos(int counting) {
        List<Lotto> randomLottos = new ArrayList<>();
        for (int i = 0; i < counting; i++) {
            randomLottos.add(createRandomLotto());
        }
        return randomLottos;
    }

    private Lotto createRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
