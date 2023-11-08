package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.model.LottoCount;
import lotto.model.Lottos;

public class LottoGenerator {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int LOTTO_LENGTH = 6;

    private LottoGenerator() {
        throw new IllegalArgumentException("[ERROR]");
    }

    public static Lottos generateLottos(LottoCount lottoCount) {
        return generateLotto(lottoCount);
    }

    public static Lottos generateLotto(LottoCount lottoCount) {
        int count = lottoCount.getLottoCount();
        List<Lotto> lottoList = new ArrayList<>();
        Lottos lottos = new Lottos(lottoList);

        while (count > 0) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_LENGTH));
            lottos.addLotto(lotto);
            count--;
        }
        return lottos;
    }
}
