package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoFactory {
    public static List<Lotto> buyLotto(Integer cost) {
        ArrayList<Lotto> lottoList = new ArrayList<>();
        while (cost > 0) {
            lottoList.add(createLotto());
            cost -= 1000;
        }
        return lottoList;
    }

    private static Lotto createLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
    }
}
