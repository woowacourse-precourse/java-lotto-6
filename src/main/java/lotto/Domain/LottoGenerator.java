package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Constant.Constant;

public class LottoGenerator {

    public static List<Lotto> makeLotties(int count) {
        List<Lotto> lotties = new ArrayList<>();
        int nowCount = 1;
        do {
            lotties.add(generate());
        } while (nowCount++ < count);
        return lotties;
    }

    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Constant.LOTTO_MIN_NUMBER, Constant.LOTTO_MAX_NUMBER,
                Constant.LOTTO_LENGTH);
        Collections.sort(numbers);

        return new Lotto(numbers);
    }
}
