package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottos {
    private final int counting;
    private final List<Lotto> randomLottos;

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
        return IntStream.range(0, counting)
                .mapToObj(lotto -> createRandomLotto())
                .collect(Collectors.toList());
    }

    private Lotto createRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
