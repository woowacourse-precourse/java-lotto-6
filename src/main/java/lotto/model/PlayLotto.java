package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PlayLotto {
    public static Lotto makeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }

    public static List<Lotto> makeLottos(int LottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        Set<List<Integer>> uniquelottos = new HashSet<>();

        while (LottoCount == 0) {
            Lotto lotto = makeLotto();
            if (!uniquelottos.add(lotto.getNumbers())) {
                lottos.add(lotto);
                LottoCount--;
            }
        }
        return lottos;
    }
}
