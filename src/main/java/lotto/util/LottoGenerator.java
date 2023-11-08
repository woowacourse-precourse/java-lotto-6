package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    static final int LOTTO_NUM_LENGTH = 6;

    public static List<Integer> createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public static List<Lotto> createLottos(int purchaseCount) {
        List<Lotto> result = new ArrayList<>();
        for(int i=0; i<purchaseCount; i++) {
            Lotto lotto = new Lotto(LottoGenerator.createLotto());
            result.add(lotto);
        }
        return result;
    }
}
