package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.Number;

public class LottoMachine {
    public static List<Lotto> issueLotto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    Number.MINIMUM.getValue(), Number.MAXIMUM.getValue(), Number.SIZE.getValue());
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
