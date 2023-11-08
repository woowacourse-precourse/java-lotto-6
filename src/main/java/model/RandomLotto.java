package model;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Lotto;
import java.util.ArrayList;
import java.util.List;

public class RandomLotto {

    private List<Lotto> allLotto;

    public List<Lotto> createAllLotto(int count) {
        allLotto = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            allLotto.add(new Lotto(createRandomLotto()));
        }
        return allLotto;
    }


    private List<Integer> createRandomLotto() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}
