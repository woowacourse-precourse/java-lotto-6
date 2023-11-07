package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.model.Lotto;

public class Player {
    private static final List<Lotto> lottoNumbrtl = new ArrayList<>();

    public static void addLotto() {
        lottoNumbrtl.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
    }

    public static List<Lotto> getLotto() {
        return lottoNumbrtl;
    }
}
