package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.constants.LottoValues;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class NumberGenerator {
    public static Lottos createLottos(Integer lottoCounts) {
        Lottos lottos = new Lottos();

        for (int i = 0; i < lottoCounts; i++) {
            lottos.addLotto(createLotto());
        }

        return lottos;
    }

    private static Lotto createLotto() {
        Lotto lotto = new Lotto(createUniqueRandomNumber());
        return lotto;
    }

    private static List<Integer> createUniqueRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(
                LottoValues.RANGE_MIN.getValue(),
                LottoValues.RANGE_MAX.getValue(),
                LottoValues.NUMBERS_COUNT.getValue()
        );
    }
}
