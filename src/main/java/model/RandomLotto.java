package model;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import java.util.ArrayList;
import java.util.List;

public class RandomLotto {

    private final List<Lotto> allLotto;

    public RandomLotto() {
        allLotto = new ArrayList<>();
    }

    public List<Lotto> createAllLotto(int lottoCount) {
        for (int i = 0; i < lottoCount; i++) {
            allLotto.add(new Lotto(createRandomLotto()));
        }
        return allLotto;
    }

    public List<Integer> createRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
