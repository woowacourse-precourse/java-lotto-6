package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottos {
    private final int count;
    private final List<Lotto> randomLottos;

    public RandomLottos(Price price) {
        this.count = price.countPurchasedLotto();
        this.randomLottos = createRandomLottos(count);
    }

    public List<Lotto> getRandomLottos() {
        return randomLottos;
    }

    public int getCount() {
        return count;
    }

    private List<Lotto> createRandomLottos(int count) {
        return IntStream.range(0, count)
                .mapToObj(lotto -> makeRandomLotto())
                .collect(Collectors.toList());
    }

    private Lotto makeRandomLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
