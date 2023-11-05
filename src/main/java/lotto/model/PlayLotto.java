package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayLotto {
    public List<Lotto> lottos;
    Set<List<Integer>> uniquelottos = new HashSet<>();

    public static Lotto makeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
