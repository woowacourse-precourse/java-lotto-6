package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Game {
    private final List<Lotto> lottos = new ArrayList<>();

    public Game(final int time) {
        while (this.lottos.size() < time) {
            this.lottos.add(new Lotto(makeSorted(Randoms.pickUniqueNumbersInRange(1, 45, 6))));
        }
    }

    private List<Integer> makeSorted(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
