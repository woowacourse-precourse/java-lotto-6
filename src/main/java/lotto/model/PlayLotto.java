package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayLotto {
    public static List<Lotto> lottos;
    static Set<List<Integer>> uniquelottos = new HashSet<>();

    public static Lotto makeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static void makeLottos(int LottoCount) {
        while (LottoCount == 0) {
            Lotto lotto = makeLotto();
                lottos.add(lotto);
                LottoCount--;
        }
    }
}
